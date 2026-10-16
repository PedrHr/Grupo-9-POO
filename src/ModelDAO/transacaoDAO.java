package ModelDAO;

import Model.Transacao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class transacaoDAO {

    public String inserirTransacao(Transacao transacao) {
            if (transacao == null) {
                return "Não foi possível realizar a transação: dados ausentes.";
            }
            double valorInformado = transacao.getValor();
            if (!Double.isFinite(valorInformado) || valorInformado <= 0) {
                return "O valor da transferência deve ser maior que zero.";
            }
            if (transacao.getContaOrigem() <= 0) {
                return "A conta de origem é inválida.";
            }
            if (transacao.getContaDestino() <= 0) {
                return "Informe uma chave de transferência válida para o destino.";
            }
            if (transacao.getDataTransacao() == null) {
                return "A data da transferência é obrigatória.";
            }

        final BigDecimal valor;
        try {
            // O banco armazena valores monetários com duas casas decimais.
            valor = BigDecimal.valueOf(valorInformado)
                    .setScale(2, RoundingMode.UNNECESSARY);
        } catch (ArithmeticException ex) {
            return "Informe um valor com, no máximo, duas casas decimais.";
        }

        try (Connection conn = conexaoDAO.abrirNovaConexao()) {
            conn.setAutoCommit(false);

            try {
                int numeroContaOrigem = transacao.getContaOrigem();
                long chaveDestino = transacao.getContaDestino();

                // Confirma que a origem é uma conta corrente existente.
                String sqlOrigemValida = "SELECT idContaCorrente FROM contaCorrente WHERE idContaCorrente = ?";

                try (PreparedStatement stmt = conn.prepareStatement(sqlOrigemValida)) {
                    stmt.setInt(1, numeroContaOrigem);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (!rs.next()) {
                            return cancelar(conn, "A conta de origem não foi encontrada ou não é uma conta corrente.");
                        }
                    }
                }

                // A interface informa a chave de transferência do destinatário.
                String sqlDestino =
                        "SELECT idContaCorrente FROM contaCorrente WHERE chaveTransacao = ?";
                int numeroContaDestino;
                try (PreparedStatement stmt = conn.prepareStatement(sqlDestino)) {
                    stmt.setLong(1, chaveDestino);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (!rs.next()) {
                            return cancelar(conn, "A chave informada não corresponde a uma conta de destino.");
                        }
                        numeroContaDestino = rs.getInt("idContaCorrente");
                    }
                }

                if (numeroContaOrigem == numeroContaDestino) {
                    return cancelar(conn, "A conta de origem e a conta de destino não podem ser iguais.");
                }

                // Bloqueia os saldos até commit/rollback. ORDER BY ajuda a obter
                // os bloqueios em ordem consistente nas transferências cruzadas.
                String sqlBloquearSaldos =
                        "SELECT numeroConta, saldoAtual FROM Conta " +
                                "WHERE numeroConta IN (?, ?) ORDER BY numeroConta FOR UPDATE";
                Map<Integer, BigDecimal> saldos = new HashMap<>();
                try (PreparedStatement stmt = conn.prepareStatement(sqlBloquearSaldos)) {
                    stmt.setInt(1, numeroContaOrigem);
                    stmt.setInt(2, numeroContaDestino);
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            saldos.put(rs.getInt("numeroConta"), rs.getBigDecimal("saldoAtual"));
                        }
                    }
                }

                if (!saldos.containsKey(numeroContaOrigem)
                        || !saldos.containsKey(numeroContaDestino)) {
                    return cancelar(conn, "Não foi possível localizar as duas contas da transferência.");
                }

                BigDecimal saldoOrigem = saldos.get(numeroContaOrigem);
                if (saldoOrigem == null || saldoOrigem.compareTo(valor) < 0) {
                    return cancelar(conn, "Saldo insuficiente para realizar a transferência.");
                }

                // A condição no UPDATE é uma segunda proteção contra saldo insuficiente.
                String sqlDebitar =
                        "UPDATE Conta SET saldoAtual = saldoAtual - ? " +
                                "WHERE numeroConta = ? AND saldoAtual >= ?";
                try (PreparedStatement stmt = conn.prepareStatement(sqlDebitar)) {
                    stmt.setBigDecimal(1, valor);
                    stmt.setInt(2, numeroContaOrigem);
                    stmt.setBigDecimal(3, valor);
                    if (stmt.executeUpdate() != 1) {
                        return cancelar(conn, "O saldo mudou ou é insuficiente. A transferência não foi realizada.");
                    }
                }

                String sqlCreditar =
                        "UPDATE Conta SET saldoAtual = saldoAtual + ? WHERE numeroConta = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sqlCreditar)) {
                    stmt.setBigDecimal(1, valor);
                    stmt.setInt(2, numeroContaDestino);
                    if (stmt.executeUpdate() != 1) {
                        return cancelar(conn, "Não foi possível creditar o valor na conta de destino.");
                    }
                }

                // Registra a transferência somente dentro da mesma transação SQL.
                String sqlInserir =
                        "INSERT INTO Transacao (valor, contaOrigem, contaDestino, dataTransacao) " +
                                "VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(
                        sqlInserir, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setBigDecimal(1, valor);
                    stmt.setInt(2, numeroContaOrigem);
                    stmt.setInt(3, numeroContaDestino);
                    stmt.setTimestamp(4, Timestamp.valueOf(transacao.getDataTransacao()));

                    if (stmt.executeUpdate() != 1) {
                        throw new SQLException("O registro da transferência não foi criado.");
                    }

                    try (ResultSet keys = stmt.getGeneratedKeys()) {
                        if (!keys.next()) {
                            throw new SQLException("O banco não retornou o código da transferência.");
                        }
                        transacao.setIdTransacao(keys.getInt(1));
                    }
                }

                conn.commit();

                // Atualiza o objeto para que o relatório mostre o número da conta,
                // não a chave usada para localizar o destinatário.
                transacao.setContaDestino(numeroContaDestino);
                return "Transação realizada com sucesso.";

            } catch (SQLException ex) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    ex.addSuppressed(rollbackEx);
                }
                throw ex;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao realizar a transferência. Nenhuma alteração foi confirmada no banco de dados.";
        }
    }

    private String cancelar(Connection conn, String mensagem) throws SQLException {
        conn.rollback();
        return mensagem;
    }

    public List<Transacao> buscarExtrato(int numeroConta) {
        List<Transacao> transacoes = new ArrayList<>();

        String sql = "SELECT valor, contaOrigem, contaDestino, dataTransacao " +
                "FROM Transacao WHERE contaOrigem = ? OR contaDestino = ? " +
                "ORDER BY dataTransacao DESC";

        try (Connection conn = conexaoDAO.abrirNovaConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numeroConta);
            stmt.setInt(2, numeroConta);

            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    Timestamp timestamp = result.getTimestamp("dataTransacao");
                    if (timestamp == null) {
                        continue;
                    }

                    Transacao transacao = new Transacao(
                            result.getDouble("valor"),
                            result.getInt("contaOrigem"),
                            result.getInt("contaDestino"),
                            timestamp.toLocalDateTime()
                    );
                    transacoes.add(transacao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transacoes;
    }
}

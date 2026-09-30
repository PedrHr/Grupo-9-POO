package ModelDAO;

import Model.Cliente;
import Model.Transacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class transacaoDAO {
    public String inserirTransacao(Transacao transacao) {

        String sqlBuscarContaDestino = "SELECT idContaCorrente FROM contaCorrente WHERE chaveTransacao = ?";

        String sql = "INSERT INTO Transacao (valor, contaOrigem, contaDestino, dataTransacao) VALUES (?, ?, ?, ?)";

        String sqlSaldoOrigem = "UPDATE Conta SET saldoAtual = saldoAtual - ? WHERE numeroConta = ?";

        String sqlSaldoDestino = "UPDATE Conta SET saldoAtual = saldoAtual + ? WHERE numeroConta = ?";

        try {

            // Buscar a conta destino pela chave
            PreparedStatement stmtBusca = conexaoDAO.getConexao().prepareStatement(sqlBuscarContaDestino);

            stmtBusca.setLong(1, transacao.getContaDestino());

            ResultSet result = stmtBusca.executeQuery();

            if (!result.next()) {
                return "Conta destino não encontrada.";
            }

            int idContaDestino = result.getInt("idContaCorrente");

            System.out.println(idContaDestino);

            PreparedStatement stmt = conexaoDAO.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setDouble(1, transacao.getValor());
            stmt.setInt(2, transacao.getContaOrigem());
            stmt.setInt(3, idContaDestino);
            stmt.setObject(4, transacao.getDataTransacao());

            int linhasInsert = stmt.executeUpdate();

            // Pegar id
            ResultSet keys = stmt.getGeneratedKeys();

            if (keys.next()) {

                int idGerado = keys.getInt(1);

                transacao.setIdTransacao(idGerado);

            } else {
                System.out.println("Não foi gerado id para a transação.");
            }

            // Tirar dinheiro da conta origem
            PreparedStatement stmtOrigem = conexaoDAO.getConexao().prepareStatement(sqlSaldoOrigem);

            stmtOrigem.setDouble(1, transacao.getValor());
            stmtOrigem.setInt(2, transacao.getContaOrigem());

            int linhasOrigem = stmtOrigem.executeUpdate();

            // Adicionar slado na conta destino
            PreparedStatement stmtDestino = conexaoDAO.getConexao().prepareStatement(sqlSaldoDestino);

            stmtDestino.setDouble(1, transacao.getValor());
            stmtDestino.setInt(2, idContaDestino);

            int linhasDestino = stmtDestino.executeUpdate();

            return "Transação realizada com sucesso.";

        } catch (SQLException e) {

            System.out.println("Erro transação");
            e.printStackTrace();

            return "Erro ao realizar transação.";

        }
    }

    public List<Transacao> buscarExtrato(int numeroConta) {

        List<Transacao> transacoes = new ArrayList<>();

        String sql = " SELECT valor, contaOrigem, contaDestino, dataTransacao FROM Transacao WHERE contaOrigem = ? OR contaDestino = ? ORDER BY dataTransacao DESC ";

        try {
            PreparedStatement stmt =
                    conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setInt(1, numeroConta);
            stmt.setInt(2, numeroConta);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {

                Transacao transacao = new Transacao(result.getDouble("valor"), result.getInt("contaOrigem"), result.getInt("contaDestino"), result.getTimestamp("dataTransacao").toLocalDateTime());

                transacoes.add(transacao);
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transacoes;
    }

}

package ModelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.Cliente;
import ModelDAO.conexaoDAO;
import Model.Conta;
import Model.contaCorrente;
import Model.contaPoupanca;

public class contaDAO {
    public String inserirConta(Conta conta) {

        String sql = "INSERT INTO CONTA (SALDOATUAL, TIPO, IDCLIENTE_CLIENTE) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexaoDAO.getConexao().prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            stmt.setDouble(1, conta.getSaldoAtual());
            stmt.setString(2, conta.getTipoConta());
            stmt.setInt(3, conta.getCliente().getIdCliente());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                int numeroConta = rs.getInt(1);
                conta.setNumeroConta(numeroConta);
            }

            stmt.close();

            // Conta Corrente
            if (conta instanceof contaCorrente) {

                contaCorrente corrente = (contaCorrente) conta;

                sql = "INSERT INTO CONTACORRENTE (IDCONTACORRENTE, LIMITECREDITO) VALUES (?,?)";

                stmt = conexaoDAO.getConexao().prepareStatement(sql);
                corrente.setLimiteCredito(conta.getSaldoAtual() /2);
                stmt.setInt(1, conta.getNumeroConta());
                stmt.setDouble(2, corrente.getLimiteCredito());

                stmt.executeUpdate();

                stmt.close();
            }

            // Conta Poupança
            else if (conta instanceof contaPoupanca) {

                contaPoupanca poupanca = (contaPoupanca) conta;

                sql = "INSERT INTO CONTAPOUPANCA (idContaPoupanca, taxaRendimento) VALUES (?, ?)";

                stmt = conexaoDAO.getConexao().prepareStatement(sql);
                poupanca.setTaxaRendimento(0.010);
                stmt.setInt(1, conta.getNumeroConta());
                stmt.setDouble(2, poupanca.getTaxaRendimento());

                stmt.executeUpdate();

                stmt.close();
            }

            return "Conta inserida com sucesso";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao inserir conta";
        }
    }

    public String inserirDeposito(Conta conta) {

        System.out.println(conta.getSaldoAtual());
        String sql = "UPDATE CONTA SET saldoAtual = ? WHERE numeroConta = ?";

        System.out.println(conta.getNumeroConta());

        try {
            PreparedStatement stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setDouble(1, conta.getSaldoAtual());
            stmt.setInt(2, conta.getNumeroConta());

            stmt.executeUpdate();

            stmt.close();

            return "Deposito inserido com sucesso";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao depositar valor na conta";
        }
    }

    public String sacarvalor(Conta conta) {

        System.out.println(conta.getSaldoAtual());
        String sql = "UPDATE CONTA SET saldoAtual = ? WHERE numeroConta = ?";

        System.out.println(conta.getNumeroConta());

        try {
            PreparedStatement stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setDouble(1, conta.getSaldoAtual());
            stmt.setInt(2, conta.getNumeroConta());

            stmt.executeUpdate();

            stmt.close();

            return "Valor sacada da sua conta com sucesso!";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao depositar valor na conta";
        }
    }
}

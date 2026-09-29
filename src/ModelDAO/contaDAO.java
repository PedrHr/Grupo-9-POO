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
    public String inserirConta(Cliente cliente, Conta conta, String tipoConta) {

        String sql = "INSERT INTO CONTA (SALDOATUAL, TIPOCONTA, IDCLIENTE_CLIENTE) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conexaoDAO.getConexao().prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            stmt.setDouble(1, conta.getSaldoAtual());
            stmt.setDouble(2, conta.getTipoConta());
            stmt.setInt(2, cliente.getIdCliente());

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

                sql = "INSERT INTO CONTACORRENTE (idContaCorrente) VALUES (?)";

                stmt = conexaoDAO.getConexao().prepareStatement(sql);

                stmt.setInt(1, conta.getNumeroConta());

                stmt.executeUpdate();

                stmt.close();
            }

            // Conta Poupança
            else if (conta instanceof contaPoupanca) {

                contaPoupanca poupanca = (contaPoupanca) conta;

                sql = "INSERT INTO CONTAPOUPANCA (idContaPoupanca, taxaRendimento) VALUES (?, ?)";

                stmt = conexaoDAO.getConexao().prepareStatement(sql);

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
}

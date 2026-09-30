package ModelDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Conta;
import Model.contaCorrente;
import Model.contaPoupanca;
import ModelDAO.conexaoDAO;

import Model.Cliente;

import javax.swing.*;

public class clienteDAO {
    public String inserirCliente(Cliente cliente) {

        String sql = "INSERT INTO CLIENTE (NOME, CPF, ENDERECO, EMAIL, SENHA) VALUES (?,?,?,?,?)";

        try {

            PreparedStatement stmt = conexaoDAO.getConexao().prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getSenha());

            stmt.executeUpdate();

            // Recupera o id

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                int idCliente = rs.getInt(1);
                cliente.setIdCliente(idCliente);
                System.out.println(cliente.getIdCliente());

            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Nao foi cadastrar-lo, tente novamente mais tarde.");
        }

        return sql;
    }

    public Cliente buscarCliente(String email, String senha) {
        String sql = "SELECT * FROM CLIENTE WHERE email = ? AND senha = ? ";
        PreparedStatement stmt = null;


        try {
            stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);
            stmt.execute();
            ResultSet result = stmt.executeQuery();


            if (result.next()) {
                Cliente cliente = new Cliente(result.getString("nome"), result.getString("cpf"), result.getString("endereco"), result.getString("email"), result.getString("senha"));
                cliente.setIdCliente(result.getInt("idCliente"));
                stmt.close();
                return cliente;

            } else {
                JOptionPane.showMessageDialog(null, "Nao foi possivel encontrar o usuário");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "O usuário informado não existe");
        }
        return null;
    }

    public Conta buscarContaCliente(Cliente cliente) {

        String sql = "SELECT * FROM Conta WHERE idcliente_cliente = ?";

        try {
            PreparedStatement stmt =
                    conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setInt(1, cliente.getIdCliente());

            ResultSet result = stmt.executeQuery();


            if (result.next()) {
                Conta.TipoConta tipo = Conta.TipoConta.valueOf(result.getString("tipo"));
                if (tipo == Conta.TipoConta.CORRENTE) {
                    contaCorrente contaCorrente = new contaCorrente(result.getInt("saldoAtual"), tipo, cliente);
                    contaCorrente.gerarLimiteCredito();
                    contaCorrente.setNumeroConta(result.getInt("numeroConta"));
                    return contaCorrente;
                } else {
                    contaPoupanca contaPoupanca = new contaPoupanca(result.getInt("saldoAtual"), tipo, cliente);
                    contaPoupanca.setNumeroConta(result.getInt("numeroConta"));
                    return contaPoupanca;
                }
            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

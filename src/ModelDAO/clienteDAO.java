package ModelDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ModelDAO.conexaoDAO;

import Model.Cliente;

public class clienteDAO {
    public void inserirCliente(Cliente cliente){
        String sql = "INSERT INTO Cliente (nome, cpf, endereco, email, senha) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = conexaoDAO.getConexao().prepareStatement(sql);
            stmt.setString(1, Cliente.getNome());
            stmt.setString(2, Cliente.getCpf());
            stmt.setString(3, Cliente.getEndereco());
            stmt.setString(4, Cliente.getEmail());
            stmt.setString(5, Cliente.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

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
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEndereco());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

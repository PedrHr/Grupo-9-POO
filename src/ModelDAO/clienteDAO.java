package ModelDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ModelDAO.conexaoDAO;

import Model.Cliente;

public class clienteDAO {
    public void inserirCliente(Cliente cliente){

        String sql = "INSERT INTO CLIENTE (NOME, CPF, ENDERECO, EMAIL, SENHA) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;


        try {
            stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getSenha());
            System.out.println("tudo certo");
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("tudo errado");
        }
    }
}

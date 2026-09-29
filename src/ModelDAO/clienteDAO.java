package ModelDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ModelDAO.conexaoDAO;

import Model.Cliente;

public class clienteDAO {
    public String inserirCliente(Cliente cliente){

        String sql = "INSERT INTO CLIENTE (NOME, CPF, ENDERECO, EMAIL, SENHA) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;


        try {
            stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getSenha());
            stmt.execute();


            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("tudo errado");
        }
        return sql;
    }

    public Cliente buscarCliente(String email, String senha){
        String sql = "SELECT * FROM CLIENTE WHERE email = ? AND senha = ? ";
        PreparedStatement stmt = null;


        try {
            stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);
            stmt.execute();
            ResultSet result = stmt.executeQuery();


            if(result.next()) {
            System.out.println("Cliente encontrado");

            Cliente cliente = new Cliente(
             result.getString("nome"),
             result.getString("cpf"),
             result.getString("endereco"),
             result.getString("email"),
             result.getString("senha")
             );

            cliente.setIdCliente(result.getInt("idCliente"));

            stmt.close();
            return cliente;

            }else{
                System.out.println("Cliente nao encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("tudo errado");
        }
        return null;
    }
}

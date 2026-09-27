//package ModelDAO;
//
//import Model.Cliente;
//import Model.Transacao;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class transacaoDAO {
//    public String inserirTransacao(Transacao transacao){
//
//        String sql = "INSERT INTO TRANSACAO (NOME, CPF, ENDERECO, EMAIL, SENHA) VALUES (?,?,?,?,?)";
//        PreparedStatement stmt = null;
//
//
//        try {
//            stmt = conexaoDAO.getConexao().prepareStatement(sql);
//
//            stmt.setString(1, cliente.getNome());
//            stmt.setString(2, cliente.getCpf());
//            stmt.setString(3, cliente.getEndereco());
//            stmt.setString(4, cliente.getEmail());
//            stmt.setString(5, cliente.getSenha());
//            stmt.execute();
//
//
//            stmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return System.out.println("tudo errado");
//        }
//    }
//}

package ModelDAO;

import Model.Cliente;
import Model.Transacao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class transacaoDAO {
    public String inserirTransacao(Transacao transacao){

        String sql = "INSERT INTO TRANSACAO (VALOR, CONTAORIGEM, CONTADESTINO, DATA) VALUES (?,?,?,?)";
        PreparedStatement stmt = null;


        try {
            stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setString(1, transacao.getValor());
            stmt.setString(2, transacao.getContaOrigem());
            stmt.setString(3, transacao.getContaDestino());
            stmt.setString(4, transacao.getDataTransacao());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return System.out.println("tudo errado");
        }
    }
}

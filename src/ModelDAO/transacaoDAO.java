package ModelDAO;

import Model.Cliente;
import Model.Transacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class transacaoDAO {
    public String inserirTransacao(Transacao transacao){

        String sql = "INSERT INTO TRANSACAO (VALOR, CONTAORIGEM, CONTADESTINO, DATA) VALUES (?,?,?,?)";
        PreparedStatement stmt = null;


        try {
            stmt = conexaoDAO.getConexao().prepareStatement(sql);

            stmt.setDouble(1, transacao.getValor());
            stmt.setInt(2, transacao.getContaOrigem());
            stmt.setLong(3, transacao.getContaDestino());
            stmt.setObject(4, transacao.getDataTransacao());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                transacao.setIdTransacao(rs.getInt("idTransacao"));
            }

            stmt.close();



        } catch (SQLException e) {
            e.printStackTrace();
            return System.out.println("tudo não foi possivel efetuar a transação");
        }
        return null;
    }
}

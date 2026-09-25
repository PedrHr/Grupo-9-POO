package ModelDAO;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class conexaoDAO {
    private static final String url = "jdbc:mysql://localhost:3306/contaBancaria";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn;

    public static Connection getConexao() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user,  password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException excecao){
            excecao.printStackTrace();
            return null;
        }

    }
}

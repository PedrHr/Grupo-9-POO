package ModelDAO;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class conexaoDAO {
    private static final String url = "jdbc:mysql://localhost:3306/systemBank";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn;

    public static Connection getConexao() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                JOptionPane.showMessageDialog(null, "Base de dados encontrada com sucesso");
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException excecao) {
            excecao.printStackTrace();
            JOptionPane.showMessageDialog(null, "Nao foi possivel estabelcer conexao com o Banco de Dados");
            return null;
        }

    }
}

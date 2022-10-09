import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public static Connection getConnection() {
        java.sql.Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/db-bankdata?serverTimezone=CET&useSSL=false";
        String user = "root";
        String password = "Ysr5123mqr";


        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

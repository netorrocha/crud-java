package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/crud";
        String user = "root";
        String password = "1234567";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
}

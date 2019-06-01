package sdju.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private final static String USERNAME = "teech1";
    private final static String PASSWORD = "teech1!gearhostDatabase";
    private final static String CONNSTRING = "jdbc:mysql://den1.mysql2.gear.host/teech1?useSSL=false";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || !connection.isValid(1)){
            System.out.println("Connecting to the database...");
            connection = DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
        }
        return connection;
    }
}

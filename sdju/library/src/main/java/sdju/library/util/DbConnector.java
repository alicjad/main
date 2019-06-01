package sdju.library.util;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DbConnector {

    private final String USERNAME = "teech1";
    private final String PASSWORD = "teech1!gearhostDatabase";
    private final String CONNSTRING = "jdbc:mysql://den1.mysql2.gear.host/teech1?useSSL=false";
    private Connection connection;
    private long connectionTime;
    private final int disconnectionTime = 600000;

    public DbConnector() throws SQLException {
        this.establishNewConnection();
    }

    public Connection getConnection() throws SQLException {
        this.refreshConnection();
        return this.connection;
    }

    private void refreshConnection() throws SQLException {
        if (System.currentTimeMillis() - this.connectionTime > disconnectionTime) {
            this.establishNewConnection();
        }
    }

    private void establishNewConnection() throws SQLException {
        System.out.println("Connecting to the database...");
        this.connectionTime = System.currentTimeMillis();
        this.connection = DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
    }
}

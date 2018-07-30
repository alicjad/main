package alic.students.repositories.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private final static String USERNAME = "springdbalic";
    private final static String PASSWORD = "spring!Dbconnection";
    private final static String CONNSTRING = "jdbc:mysql://den1.mysql3.gear.host/springdbalic?useSSL=false";

    public static Connection getConnection(){

        try {
            System.out.println("Yes, it's connected!");
            return DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

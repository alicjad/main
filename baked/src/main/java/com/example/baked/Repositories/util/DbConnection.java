package com.example.baked.Repositories.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    //Credentials and strings
    private static final String USERNAME = "swcexercise";
    private static final String PASSWORD = "Kz2S5NgGq!f_";
    private static final String CONNSTRING = "jdbc:mysql://den1.mysql6.gear.host/swcexercise?useSSL=false";

    //Creates a connection and returns it
    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}

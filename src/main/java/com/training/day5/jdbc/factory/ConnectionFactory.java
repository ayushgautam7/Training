package com.training.day5.jdbc.factory;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection con = null;
    private ConnectionFactory(){
    }
    public static Connection getConnection(){
        //using to get key and values
        Properties properties=new Properties();

        try {
            properties.load(new FileReader("db.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }
        String driver=properties.getProperty("jdbc.driver");
        String user=properties.getProperty("jdbc.username");
        String password=properties.getProperty("jdbc.password");
        String url=properties.getProperty("jdbc.url");

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }

        try {
            con= DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            System.out.println(e);
        }
       return con;
    }
}

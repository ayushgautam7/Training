package com.training.day5.jdbc;

import java.sql.*;

public class UsingARMjdbc {
    public static void main(String[] args) {
        //load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }

        // here we are using ARM so that we don't need to write finally block
        // for that we write our connection inside try so that after execution it will terminate automatically
        try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ukgTraining","root","password")) {
            System.out.println("Connection is done");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");
            while (rs.next()){
                System.out.println(rs.getInt(1)+": "+
                        rs.getString(2)+": "+ rs.getDouble(3));
            }
        }catch (SQLException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

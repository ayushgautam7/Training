package com.training.day5.jdbc.connection;

import com.mysql.cj.PerConnectionLRUFactory;

import java.sql.*;

public class Connection_mysql {
    public static void main(String[] args) {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch(ClassNotFoundException e){
           System.out.println(e);
        }
       Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ukgTraining","root","password");
            System.out.println("Connection is done");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+": "+rs.getString(2)+": "+rs.getDouble(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if (con !=null)
                try{
                    con.close();
                }catch(SQLException e){
                    System.out.println("Some error");
                }
        }

    }

}

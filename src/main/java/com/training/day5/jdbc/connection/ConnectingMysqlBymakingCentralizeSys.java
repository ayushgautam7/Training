package com.training.day5.jdbc.connection;

import com.training.day5.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectingMysqlBymakingCentralizeSys {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnection();
        try{
            Statement stmt  = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next()){
                System.out.println(rs.getInt(1)+": "+rs.getString(2)+": "+rs.getDouble(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }finally{
            if (con!=null){
                try{
                    con.close();
                }catch (SQLException e){
                    System.out.println("some ex");
                }
            }
        }
    }
}

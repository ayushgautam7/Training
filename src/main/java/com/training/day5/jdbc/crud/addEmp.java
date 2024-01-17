package com.training.day5.jdbc.crud;

import com.training.day5.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addEmp {
    public static void main(String[] args) {
        Connection connection= ConnectionFactory.getConnection();
        //i want to add a records : PrepareStatement

        try {
            PreparedStatement pstmt=connection.
                    prepareStatement("insert into emp(name,salary) values (?,?)");
            pstmt.setString(1, "amit");
            pstmt.setDouble(2, 34000);
            int noOfRowsEffected= pstmt.executeUpdate();
            System.out.println(noOfRowsEffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.training.day5.jdbc.crud;

import com.training.day5.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateEmp {
    public static void main(String[] args) {
        Connection connection= ConnectionFactory.getConnection();
        //i want to add a records : PrepareStatement

        try {
            PreparedStatement pstmt=connection.
                    prepareStatement("update emp set salary=? where id=?");
            pstmt.setDouble(1, 38000);
            pstmt.setInt(2, 4);
            int noOfRowsEffected= pstmt.executeUpdate();
            System.out.println(noOfRowsEffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

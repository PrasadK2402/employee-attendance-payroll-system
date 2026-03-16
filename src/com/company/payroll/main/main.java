package com.company.payroll.main;



import com.company.payroll.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.getConnection();
        System.out.println("Database connected");
    }
}

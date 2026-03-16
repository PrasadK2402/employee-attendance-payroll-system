package com.company.payroll.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection  {
        private static final String  URL = "jdbc:mysql://localhost:3306/company_db";
    private static final   String USERNAME = "root";
    private static final String PASSWORD = "2402";
    public  static Connection getConnection() throws SQLException{

        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;




    }

}

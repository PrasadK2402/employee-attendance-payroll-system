package com.company.payroll.dao;

import com.company.payroll.model.Employee;
import com.company.payroll.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
   public  boolean addEmployee(Employee emp) throws SQLException {
            Connection conn = DBConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("insert into employees (name, department, base_salary, join_date) VALUES(?,?,?,?)");
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getDepartment());
            preparedStatement.setInt(3,emp.getBaseSalary());
            preparedStatement.setDate(4, new java.sql.Date(emp.getJoinDate().getTime()));
            int n = preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

        return n > 0;
    }
}

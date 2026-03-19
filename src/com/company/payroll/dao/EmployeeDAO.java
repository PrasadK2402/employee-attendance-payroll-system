package com.company.payroll.dao;

import com.company.payroll.model.Employee;
import com.company.payroll.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Employee> getAllEmployees() throws SQLException {
            Connection conn = DBConnection.getConnection();
            List<Employee> list = new ArrayList<>();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from employees");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmpId(rs.getInt("emp_id"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));
                employee.setBaseSalary(rs.getInt("base_salary"));
                employee.setJoinDate(rs.getDate("join_date"));
                list.add(employee);
            }
            rs.close();
            preparedStatement.close();
            conn.close();
            return list;
    }
}

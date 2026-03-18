package com.company.payroll.main;

import com.company.payroll.dao.EmployeeDAO;
import com.company.payroll.model.Employee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Enter department: ");
        String department = sc.nextLine();

        System.out.println("Enter Salary: ");
        int salary = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Joining Date in YYYY-MM-DD format only: ");
        String dateStr = sc.nextLine();
        Date date = java.sql.Date.valueOf(dateStr);

        Employee emp = new Employee();
        emp.setName(name);
        emp.setDepartment(department);
        emp.setBaseSalary(salary);
        emp.setJoinDate(date);

        EmployeeDAO dao = new EmployeeDAO();
        boolean success = dao.addEmployee(emp);
        if(success)
            System.out.println("Employee added successfully");
        else
            System.out.println("Failed to add employee");


    }
}

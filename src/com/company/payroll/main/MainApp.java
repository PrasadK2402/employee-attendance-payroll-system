package com.company.payroll.main;

import com.company.payroll.dao.EmployeeDAO;
import com.company.payroll.model.Employee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while(true){

            System.out.println("1. Add employee");
            System.out.println("2. View all the employees");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
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

                    boolean success = dao.addEmployee(emp);

                    if(success)
                        System.out.println("Employee added successfully");
                    else
                        System.out.println("Failed to add employee");
                    System.out.println("");
                    break;

                case 2:
                    List<Employee> list = dao.getAllEmployees();
                    for(Employee e: list){
                        System.out.println(e.toString());
                    }
                    System.out.println("");
                    break;

                default:
                    System.out.println("Exiting....");
                    return;
            }

        }






    }
}

package com.company.payroll.main;

import com.company.payroll.dao.AttendanceDAO;
import com.company.payroll.dao.EmployeeDAO;
import com.company.payroll.model.Attendance;
import com.company.payroll.model.Employee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        AttendanceDAO attendanceDAO = new AttendanceDAO();

        while(true){
            System.out.println("");
            System.out.println("----***---***----");
            System.out.println("1. Add employee");
            System.out.println("2. View all the employees");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Exit");

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
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Please enter Employee Id: ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("What is today's date in (YYYY-MM-DD): ");
                    String tDate = sc.nextLine();
                    Date tdate1 = java.sql.Date.valueOf(tDate);
                    Attendance att = new Attendance();
                    att.setEmpId(empId);
                    att.setDate(tdate1);
                    if(!attendanceDAO.markAttendance(att)){
                        System.out.println("Attendance already marked for this date \n");
                        break;
                    }

                    System.out.println("Enter status (Present/Absent/Leave):");
                    String status = sc.nextLine();
                    att.setStatus(status);
                    System.out.println("Your status is marked");
                    break;


                default:
                    System.out.println("Exiting....");
                    return;
            }

        }






    }
}

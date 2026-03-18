package com.company.payroll.model;

import java.sql.Date;

public class Employee {
    private int empId;
    private String name;
    private String department;
    private int baseSalary;
    private Date joinDate;

    public Employee(){ }

    public Employee(int empId,String name,String department,  int baseSalary, Date joinDate) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", empId=" + empId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                "baseSalary=" + baseSalary +
                ", joinDate=" + joinDate +
                '}';
    }
}

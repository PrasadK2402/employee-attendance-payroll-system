package com.company.payroll.model;

import java.sql.Date;

public class Attendance {
    private int attendanceId;
    private int empId;
    private Date date;
    private String status;

    public Attendance(){
    }

    public Attendance(int attendanceId, int empId, Date date,  String status) {
        this.attendanceId = attendanceId;
        this.empId = empId;
        this.date = date;
        this.status = status;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", empId=" + empId +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}

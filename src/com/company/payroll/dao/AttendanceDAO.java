package com.company.payroll.dao;

import com.company.payroll.model.Attendance;
import com.company.payroll.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AttendanceDAO {
    public boolean markAttendance(Attendance att) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps     = connection.prepareStatement("SELECT * FROM attendance  WHERE EMP_ID = ? AND DATE = ?");

        ps.setInt(1,att.getEmpId());
        ps.setDate(2,att.getDate());
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            rs.close();
            connection.close();
            return false;
        }
        else{
            PreparedStatement ps1 = connection.prepareStatement("INSERT INTO attendance (emp_id, date, status)  VALUES (?,?,?)" );
            ps1.setInt(1,att.getEmpId());
            ps1.setDate(2, att.getDate());
            ps1.setString(3, att.getStatus());
            int rows =  ps1.executeUpdate();
            ps.close();
            ps1.close();
            connection.close();
            return rows >0;


        }

    }

}

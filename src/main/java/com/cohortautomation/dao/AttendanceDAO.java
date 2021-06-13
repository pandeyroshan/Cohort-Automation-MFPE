package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.cohortautomation.beans.Attendance;

public class AttendanceDAO {
	
	public static boolean markPresent(String username) {
		Connection con = DBConnection.getConnection();
		try {
			if(!isPresent(username)) {
				PreparedStatement stmt = con.prepareStatement("insert into attendance (employee_id, date, is_present, timestamp) values(?, CURDATE(), 1, NOW())");
				stmt.setInt(1, Integer.parseInt(username));
				int result = stmt.executeUpdate();
				
				if(result>0) {
					return true;
				} else {
					return false;
			}
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static List<Attendance> getAllAttendance(String username) {
		return null;
	}

	public static Boolean isPresent(String username) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from attendance where employee_id = ? and date = CURDATE()");
			stmt.setInt(1,  Integer.parseInt(username));
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				System.out.println(result.getInt(2));
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
}

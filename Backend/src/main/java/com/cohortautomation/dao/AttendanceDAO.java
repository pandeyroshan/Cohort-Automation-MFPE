package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cohortautomation.beans.Attendance;

public class AttendanceDAO {

	public static boolean markPresent(String username) {
		Connection con = DBConnection.getConnection();
		try {
			if (!isPresent(username)) {
				PreparedStatement stmt = con.prepareStatement(
						"insert into attendance (employee_id, date, is_present, timestamp) values(?, CURDATE(), 1, NOW())");
				stmt.setInt(1, Integer.parseInt(username));
				int result = stmt.executeUpdate();

				if (result > 0) {
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
		Connection con = DBConnection.getConnection();
		List<Attendance> allAttendance = new ArrayList<Attendance>();
		try {
			PreparedStatement stmt1 = con.prepareStatement("select cohort from user where username=?");
			stmt1.setString(1, username);

			ResultSet resutl1 = stmt1.executeQuery();
			StringBuffer sb = new StringBuffer("word");
			sb.setLength(0);

			if (resutl1.next()) {
				sb.append(resutl1.getString(1));
			}

			PreparedStatement stmt2 = con.prepareStatement("select start_date from cohort where name=?");
			stmt2.setString(1, sb.toString());

			ResultSet result2 = stmt2.executeQuery();
			LocalDate startDate = LocalDate.now();

			if (result2.next()) {
				startDate = result2.getDate(1).toLocalDate();
			}

			LocalDate todayDate = LocalDate.now();

			PreparedStatement stmt3 = con.prepareStatement("select timestamp from attendance where date=?");

			for (LocalDate i = startDate; i.isBefore(todayDate) || i.equals(todayDate); i = i.plusDays(1)) {
				stmt3.setDate(1, Date.valueOf(i));

				ResultSet result3 = stmt3.executeQuery();

				if (result3.next()) {
					Attendance attendance = new Attendance(username, i, true,
							result3.getTimestamp(1).toLocalDateTime());
					allAttendance.add(attendance);
				} else {
					Attendance attendance = new Attendance(username, i, false, null);
					allAttendance.add(attendance);
				}
			}
			Collections.reverse(allAttendance);
			return allAttendance;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Boolean isPresent(String username) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con
					.prepareStatement("select * from attendance where employee_id = ? and date = CURDATE()");
			stmt.setInt(1, Integer.parseInt(username));

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
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

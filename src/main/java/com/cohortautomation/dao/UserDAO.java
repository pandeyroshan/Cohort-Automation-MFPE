package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cohortautomation.beans.User;

public class UserDAO {
	private static Connection con = DBConnection.getConnection();

	public static boolean validate(String username, String password) {
		try {
			PreparedStatement stmt = con.prepareStatement("select * from user where username=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet result = stmt.executeQuery();

			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static User getUser(String username) {
		try {
			PreparedStatement stmt = con.prepareStatement("select * from user where username = ?");
			stmt.setString(1, username);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				User user = new User(result.getInt(2), result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getString(7));
				user.setMentor(result.getInt(9) == 0 ? false : true);
				user.setSME(result.getInt(10) == 0 ? false : true);
				user.setTrainer(result.getInt(11) == 0 ? false : true);
				user.setCoach(result.getInt(12) == 0 ? false : true);
				user.setMember(result.getInt(13) == 0 ? false : true);
				user.setLastLogin(result.getTimestamp(14).toLocalDateTime());
				user.setLastIP(result.getString(15));
				user.setFirstLogin(result.getInt(16) == 0 ? false : true);

				if (result.getInt(13) == 1) {
					// which means if user is a member than set their Cohort ( NA if user is SME,
					// Trainer, Admin, Mentor, Coach )
					user.setCohort(CohortDAO.getCohort(result.getString(17)));
				}
				user.setAdmin(result.getInt(18) == 0 ? false : true);

				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean isFirstLogin(User user) {
		try {
			PreparedStatement stmt = con.prepareStatement("select is_first_login from user where employee_id = ?");
			stmt.setInt(1, user.getEmployeeId());

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				return result.getInt(1) == 1 ? true : false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean updateLastLogin(User user) {
		try {
			PreparedStatement stmt = con.prepareStatement("update user set last_login = ? where username = ?");
			stmt.setTimestamp(1, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			stmt.setString(2, user.getUsername());

			int executeUpdate = stmt.executeUpdate();

			if (executeUpdate > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean uncheckIsFirstLogin(User user) {
		try {
			PreparedStatement stmt = con.prepareStatement("update user set is_first_login=0 where employee_id = ?;");
			stmt.setInt(1, user.getEmployeeId());

			int result = stmt.executeUpdate();

			if (result > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean createUser(User user) {
		return true;
	}

	public static boolean updatePassword(User user, String newPassword) {
		try {
			PreparedStatement stmt = con.prepareStatement("update user set password = ? where username=?");
			stmt.setString(2, user.getUsername());
			stmt.setString(1, newPassword);

			int executeUpdate = stmt.executeUpdate();

			if (executeUpdate > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}

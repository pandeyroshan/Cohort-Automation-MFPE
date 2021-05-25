package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.User;
import com.cohortautomation.utilities.MailService;

public class UserDAO {

	public static boolean validate(String username, String password) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from user where username=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet result = stmt.executeQuery();

			return result.next();
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

	public static User getUser(String username) {
		Connection con = DBConnection.getConnection();
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
				try {
					user.setLastLogin(result.getTimestamp(14).toLocalDateTime());
				} catch (Exception e) {
					user.setLastLogin(null);
				}
				user.setLastIP(result.getString(15));
				user.setFirstLogin(result.getInt(16) == 0 ? false : true);

				if (result.getInt(13) == 1) {
					Cohort cohort = CohortDAO.getCohort(result.getString(17));
					List<Cohort> myCohort = new ArrayList<Cohort>();
					myCohort.add(cohort);
					user.setMyCohorts(myCohort);
				}
				user.setAdmin(result.getInt(18) == 0 ? false : true);

				return user;
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

		return null;
	}

	public static boolean isFirstLogin(User user) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select is_first_login from user where employee_id = ?");
			stmt.setInt(1, user.getEmployeeId());

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				return result.getInt(1) == 1 ? true : false;
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

	public static boolean updateLastLogin(User user) {
		Connection con = DBConnection.getConnection();
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
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean uncheckIsFirstLogin(User user) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("update user set is_first_login=0 where employee_id = ?;");
			stmt.setInt(1, user.getEmployeeId());

			int result = stmt.executeUpdate();
			

			if (result > 0) {
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

	public static boolean createUser(User user) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into user (employee_id, username, password, first_name, last_name, personal_email, corporate_email, is_mentor, is_SME, is_trainer, is_coach, is_member, is_first_login , is_admin) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, user.getEmployeeId());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			stmt.setString(6, user.getPersonalEmail());
			stmt.setString(7, user.getPersonalEmail());
			stmt.setBoolean(8, user.isMentor());
			stmt.setBoolean(9, user.isSME());
			stmt.setBoolean(10, user.isTrainer());
			stmt.setBoolean(11, user.isCoach());
			stmt.setBoolean(12, user.isMember());
			stmt.setBoolean(13, true);
			stmt.setBoolean(14, user.isAdmin());

			int result = stmt.executeUpdate();

			if (result > 0) {
				MailService.sendCredentials(user);
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

	public static boolean updatePassword(User user, String newPassword) {
		Connection con = DBConnection.getConnection();
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
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public static List<User> getAllSME() {
		Connection con = DBConnection.getConnection();
		List<User> smeList = new ArrayList<User>();

		try {
			PreparedStatement stmt = con.prepareStatement("select * from user where is_SME = 1");
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				User user = new User(result.getInt(2), result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getString(7));
				user.setMyCohorts(CohortDAO.getAllCohortsForSME(user));
				smeList.add(user);
			}
			return smeList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<User> getAllMentor() {
		Connection con = DBConnection.getConnection();
		List<User> mentorList = new ArrayList<User>();

		try {
			PreparedStatement stmt = con.prepareStatement("select * from user where is_mentor = 1");
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				User user = new User(result.getInt(2), result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getString(7));
				user.setMyCohorts(CohortDAO.getAllCohortsForMentor(user));

				mentorList.add(user);
			}
			return mentorList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<User> getAllCoach() {
		Connection con = DBConnection.getConnection();
		List<User> coachList = new ArrayList<User>();

		try {
			PreparedStatement stmt = con.prepareStatement("select * from user where is_coach = 1");
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				User user = new User(result.getInt(2), result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getString(7));
				user.setMyCohorts(CohortDAO.getAllCohortsForCoach(user));

				coachList.add(user);
			}
			return coachList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<User> getAllTrainer() {
		Connection con = DBConnection.getConnection();
		List<User> trainerList = new ArrayList<User>();

		try {
			PreparedStatement stmt = con.prepareStatement("select * from user where is_trainer = 1");
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				User user = new User(result.getInt(2), result.getString(3), result.getString(4), result.getString(5),
						result.getString(6), result.getString(7));
				user.setMyCohorts(CohortDAO.getAllCohortsForTrainer(user));

				trainerList.add(user);
			}
			return trainerList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.User;

public class CohortDAO {

	public static Cohort getCohort(String cohortName) {
		Cohort cohort;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from cohort where name =?");
			stmt.setString(1, cohortName);

			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				cohort = new Cohort(
						result.getString(2),
						result.getString(3),
						new Date(result.getDate(4).getTime()),
						result.getInt(5)
						);
				
				cohort.setCoach(UserDAO.getUser(result.getString(6)));
				cohort.setMentor(UserDAO.getUser(result.getString(7)));
				cohort.setSME(UserDAO.getUser(result.getString(8)));
				cohort.setTrainer(UserDAO.getUser(result.getString(9)));
				
				return cohort;
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

	public static List<Cohort> getAllCohorts() {
		Connection con = DBConnection.getConnection();
		List<Cohort> cohortList = new ArrayList<Cohort>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from cohort");

			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				Cohort cohort = new Cohort(result.getString(2), result.getString(3), result.getDate(4),
						result.getInt(5));

				cohortList.add(cohort);
			}
			return cohortList;
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

	public static List<Cohort> getAllCohortsForTrainer(User user) {
		Connection con = DBConnection.getConnection();
		List<Cohort> cohortList = new ArrayList<Cohort>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from cohort where trainer_id = ?");
			stmt.setString(1, user.getUsername());

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Cohort cohort = new Cohort(result.getString(2), result.getString(3), result.getDate(4),
						result.getInt(5));

				cohortList.add(cohort);
			}
			return cohortList;
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

	public static List<Cohort> getAllCohortsForCoach(User user) {
		Connection con = DBConnection.getConnection();
		List<Cohort> cohortList = new ArrayList<Cohort>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from cohort where coach_id = ?");
			stmt.setString(1, user.getUsername());

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Cohort cohort = new Cohort(result.getString(2), result.getString(3), result.getDate(4),
						result.getInt(5));

				cohortList.add(cohort);
			}
			return cohortList;
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

	public static List<Cohort> getAllCohortsForMentor(User user) {
		Connection con = DBConnection.getConnection();
		List<Cohort> cohortList = new ArrayList<Cohort>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from cohort where mentor_id = ?");
			stmt.setString(1, user.getUsername());

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Cohort cohort = new Cohort(result.getString(2), result.getString(3), result.getDate(4),
						result.getInt(5));

				cohortList.add(cohort);
			}
			return cohortList;
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

	public static List<Cohort> getAllCohortsForSME(User user) {
		Connection con = DBConnection.getConnection();
		List<Cohort> cohortList = new ArrayList<Cohort>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from cohort where sme_id = ?");
			stmt.setString(1, user.getUsername());

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Cohort cohort = new Cohort(result.getString(2), result.getString(3), result.getDate(4),
						result.getInt(5));

				cohortList.add(cohort);
			}
			return cohortList;
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
	
	public static boolean createCohort(Cohort cohort) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into cohort (name, description, start_date, total_weeks, coach_id, mentor_id, sme_id, trainer_id) values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, cohort.getName());
			stmt.setString(2, cohort.getDescription());
			stmt.setTimestamp(3, new Timestamp(cohort.getStartdate().getTime()));
			stmt.setInt(4, cohort.getTotalWeeks());
			stmt.setString(5, cohort.getCoach().getUsername());
			stmt.setString(6, cohort.getMentor().getUsername());
			stmt.setString(7, cohort.getSME().getUsername());
			stmt.setString(8, cohort.getTrainer().getUsername());
			
			boolean result = stmt.execute();
			
			if(result) {
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
	
	public static boolean updateCohort(String oldCohortId, Cohort newCohort) {
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("update cohort set name=?, description=?, start_date=?, total_weeks=?, coach_id=?, mentor_id=?, sme_id=?, trainer_id=? where name=?");
			stmt.setString(1, newCohort.getName());
			stmt.setString(2, newCohort.getDescription());
			stmt.setTimestamp(3, new Timestamp(newCohort.getStartdate().getTime()));
			stmt.setInt(4, newCohort.getTotalWeeks());
			stmt.setString(5, newCohort.getCoach().getUsername());
			stmt.setString(6, newCohort.getMentor().getUsername());
			stmt.setString(7, newCohort.getSME().getUsername());
			stmt.setString(8, newCohort.getTrainer().getUsername());
			stmt.setString(9, oldCohortId);
			
			int result = stmt.executeUpdate();
			
			if(result>0) {
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
		
		return true;
	}
	
	public static boolean deleteCohort(String cohortId) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from cohort where name=?");
			stmt.setString(1, cohortId);
			int result = stmt.executeUpdate();
			
			if(result>0) {
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

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
	private static Connection con = DBConnection.getConnection();

	public static Cohort getCohort(String cohortName) {
		return new Cohort("INTADM21AJ021", "Java basics and Advance", new Date(), 12);
	}

	public static List<Cohort> getAllCohorts() {
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
		}

		return null;
	}

	public static List<Cohort> getAllCohortsForTrainer(User user) {
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
		}

		return null;
	}

	public static List<Cohort> getAllCohortsForCoach(User user) {
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
		}

		return null;
	}

	public static List<Cohort> getAllCohortsForMentor(User user) {
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
		}

		return null;
	}

	public static List<Cohort> getAllCohortsForSME(User user) {
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
		}

		return null;
	}
	
	public static boolean createCohort(Cohort cohort) {
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
		}
		
		
		return false;
	}
}

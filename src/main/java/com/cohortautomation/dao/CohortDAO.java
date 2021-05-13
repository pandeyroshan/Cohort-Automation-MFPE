package com.cohortautomation.dao;

import java.sql.Connection;
import java.util.Date;

import com.cohortautomation.beans.Cohort;

public class CohortDAO {
	private static Connection con = DBConnection.getConnection();
	
	public static Cohort getCohort(String cohortName) {
		return new Cohort("INTADM21AJ021", "Java basics and Advance", new Date(), 12);
	}
}

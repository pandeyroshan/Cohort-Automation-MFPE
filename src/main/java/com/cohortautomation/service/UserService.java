package com.cohortautomation.service;

import java.util.List;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.User;

public class UserService {

	public static User createSME() {
		// creates the SME: used by Admin Dashboard
		return null;
	}

	public static User createMentor() {
		// creates the Mentor: used by Admin Dashboard
		return null;
	}

	public static User createCoach() {
		// create the Coach: used by Admin Dashboard
		return null;
	}

	public static User createTrainer() {
		// create the Trainer: used by Admin Dashboard
		return null;
	}

	public static List<User> getAllSME() {
		// returns all the SMEs: used by Admin Dashboard
		return null;
	}

	public static List<User> getAllMember() {
		// returns all the Members: used by Admin Dashboard
		return null;
	}

	public static List<User> getAllTrainer() {
		return null;
	}

	public static List<User> getAllCoaches() {
		return null;
	}
	
	public static List<User> getAllMemberByCohort(Cohort cohort){
		// return all the Member of a cohort
		return null;
	}
	
	public static List<Cohort> getAllCohorts(User user){
		// return all the cohorts of a user
		return null;
	}

	public static boolean validate(String username, String password) {
		// verifies the credentials
		return true;
	}

	public static boolean changePassword(User user, String newPassword) {
		return true;
	}
}

package com.cohortautomation.service;

import java.util.List;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.LearningPath;
import com.cohortautomation.beans.User;

public class CohortService {

	public static boolean createCohort(Cohort cohort) {
		return true;
	}

	public static Cohort getCohort(int cohortID) {
		return null;
	}

	public static Cohort editCohort(Cohort oldCohort, Cohort newCohort) {
		return null;
	}

	public static boolean deleteCohort(Cohort cohort) {
		return true;
	}

	public static boolean addLearningPath(Cohort cohort, LearningPath learningPath) {
		// adds the learning path to a given cohort
		return true;
	}
	
	public static boolean removeLearningPath(Cohort cohort, LearningPath learningPath) {
		// removes the learning path to a given cohort
		return true;
	}

	public static List<Cohort> myCohorts(User user) {
		return null;
	}
	
	public static Cohort myCohort(User user) {
		return null;
	}
}

package com.cohortautomation.service;

import java.util.List;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.Survey;

public class SurveyService {
	
	public static boolean createSurvey(Survey survey) {
		return true;
	}
	
	public static Survey getSurvey(int surveyId) {
		// return the Survey 
		return null;
	}
	
	public static boolean editSurvey(Survey oldSurvey, Survey newSurvey) {
		return true;
	}
	
	public static boolean deleteSurvey(Survey survey) {
		return true;
	}
	
	public static List<Survey> getAllSurvey(Cohort cohort){
		// returns list of all survey for a cohort
		return null;
	}
	
	public static boolean deactivateSurvey(Survey survey) {
		return true;
	}
}

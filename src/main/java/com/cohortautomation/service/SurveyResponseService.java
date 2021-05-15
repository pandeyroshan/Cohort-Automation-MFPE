package com.cohortautomation.service;

import java.util.List;

import com.cohortautomation.beans.Survey;
import com.cohortautomation.beans.SurveyResponse;
import com.cohortautomation.beans.User;

public class SurveyResponseService {

	public static SurveyResponse getSurveyResponse(User user, Survey survey) {
		// returns the response for a specific user on a specific survey
		return null;
	}

	public static boolean addSurveyResponse(SurveyResponse surveyResponse) {
		// adds a response in the DB
		return true;
	}

	public static List<SurveyResponse> getAllResponse(Survey survey) {
		// returns all the responses on a Specific survey
		return null;
	}
}

package com.cohortautomation.utilities;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.User;
import com.cohortautomation.dao.AttendanceDAO;
import com.cohortautomation.dao.CohortDAO;
import com.cohortautomation.dao.MeetingDAO;
import com.cohortautomation.dao.SurveyDAO;
import com.cohortautomation.dao.UserDAO;

public class UserUtility {
	public static boolean isAuthenticated(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return false;
		}
		return true;
	}
	
	public static ModelAndView getDashboardByRole(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user.isAdmin()) {
			ModelAndView model = new ModelAndView("admin-dashboard");
			model.addObject("allCohort", CohortDAO.getAllCohorts());
			model.addObject("allSME", UserDAO.getAllSME());
			model.addObject("allMentor", UserDAO.getAllMentor());
			model.addObject("allCoach", UserDAO.getAllCoach());
			model.addObject("allTrainer", UserDAO.getAllTrainer());
			return model;
		} else if(user.isSME()) {
			ModelAndView model = new ModelAndView("dashboard");
			model.addObject("allCohort", CohortDAO.getAllCohortsForSME(user));
			model.addObject("allMeetings", MeetingDAO.getMyMeeting(user.getUsername()));
			model.addObject("allSurveys", SurveyDAO.getMySurveys(user.getUsername()));
			return model;
		} else if(user.isMentor()) {
			ModelAndView model = new ModelAndView("dashboard");
			model.addObject("allCohort", CohortDAO.getAllCohortsForMentor(user));
			model.addObject("allMeetings", MeetingDAO.getMyMeeting(user.getUsername()));
			model.addObject("allSurveys", SurveyDAO.getMySurveys(user.getUsername()));
			return model;
		} else if(user.isTrainer()) {
			ModelAndView model = new ModelAndView("dashboard");
			model.addObject("allCohort", CohortDAO.getAllCohortsForTrainer(user));
			model.addObject("allMeetings", MeetingDAO.getMyMeeting(user.getUsername()));
			return model;
		} else if(user.isCoach()) {
			ModelAndView model = new ModelAndView("dashboard");
			model.addObject("allCohort", CohortDAO.getAllCohortsForCoach(user));
			model.addObject("allMeetings", MeetingDAO.getMyMeeting(user.getUsername()));
			model.addObject("allSurveys", SurveyDAO.getMySurveys(user.getUsername()));
			return model;
		} else if(user.isMember()) {
			ModelAndView model = new ModelAndView("member-dashboard");
			model.addObject("isPresent", AttendanceDAO.isPresent(user.getUsername()));
			session.setAttribute("cohort", CohortDAO.getMyCohort(user.getUsername()).getName());
			model.addObject("myMeetings", MeetingDAO.getAllMeetingForCohort(CohortDAO.getMyCohort(user.getUsername()).getName()));
			model.addObject("allSurveys", SurveyDAO.getSurveyForCohort(CohortDAO.getMyCohort(user.getUsername()).getName()));
			return model;
		}
		return null;
	}
}
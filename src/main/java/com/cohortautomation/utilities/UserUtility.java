package com.cohortautomation.utilities;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.User;
import com.cohortautomation.dao.CohortDAO;
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
			ModelAndView model = new ModelAndView("sme-dashboard");
			return model;
		} else if(user.isMentor()) {
			ModelAndView model = new ModelAndView("mentor-dashboard");
			return model;
		} else if(user.isTrainer()) {
			ModelAndView model = new ModelAndView("trainer-dashboard");
			return model;
		} else if(user.isCoach()) {
			ModelAndView model = new ModelAndView("coach-dashboard");
			model.addObject("allCohort", CohortDAO.getAllCohortsForCoach(user));
			return model;
		} else if(user.isMember()) {
			ModelAndView model = new ModelAndView("member-dashboard");
			return model;
		}
		return null;
	}
}
// inserted a comment

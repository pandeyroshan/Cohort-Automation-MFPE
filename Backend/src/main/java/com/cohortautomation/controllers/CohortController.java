package com.cohortautomation.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.User;
import com.cohortautomation.dao.CohortDAO;
import com.cohortautomation.dao.MeetingDAO;
import com.cohortautomation.dao.SurveyDAO;
import com.cohortautomation.dao.UserDAO;
import com.cohortautomation.utilities.UserUtility;

@Controller
public class CohortController {

	@RequestMapping(value = "/view-cohort", method = RequestMethod.GET)
	public ModelAndView viewCohort(@RequestParam Map<String, String> requestData,
			HttpSession session) {
		if(UserUtility.isAuthenticated(session)) {
			String cohortId = requestData.get("cohortID");
			Cohort cohort = CohortDAO.getCohort(cohortId);
			ModelAndView model = new ModelAndView("view-cohort");
			model.addObject("cohort", cohort);
			model.addObject("allSME", UserDAO.getAllSME());
			model.addObject("allMentor", UserDAO.getAllMentor());
			model.addObject("allCoach", UserDAO.getAllCoach());
			model.addObject("allTrainer", UserDAO.getAllTrainer());
			model.addObject("allMembers", CohortDAO.getAllMembersForCohort(cohortId));
			model.addObject("allMeetings", MeetingDAO.getAllMeetingForCohort(cohortId));
			model.addObject("allSurvey", SurveyDAO.getSurveyForCohort(cohort.getName()));
			return model;
		} else {
			session.setAttribute("nextUrl", "/view-cohort?cohortID="+requestData.get("cohortID"));
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping(value="/my-cohorts", method=RequestMethod.GET)
	public ModelAndView myCohort(@RequestParam Map<String, String> requestData,
			HttpSession session) {
		if(UserUtility.isAuthenticated(session)) {
			User user = (User) session.getAttribute("user");
			ModelAndView model = new ModelAndView("my-cohorts");
			if(user.isSME()) {
				model.addObject("allCohorts", CohortDAO.getAllCohortsForSME(user));
			} else if(user.isMentor()) {
				model.addObject("allCohorts", CohortDAO.getAllCohortsForMentor(user));
			} else if(user.isCoach()) {
				model.addObject("allCohorts", CohortDAO.getAllCohortsForCoach(user));
			} else if(user.isTrainer()) {
				model.addObject("allCohorts", CohortDAO.getAllCohortsForTrainer(user));
			}
			return model;
		} else {
			session.setAttribute("nextUrl", "/my-cohorts");
			return new ModelAndView("redirect:/login");
		}
	}
}

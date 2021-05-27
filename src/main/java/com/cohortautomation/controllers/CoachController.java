package com.cohortautomation.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.User;
import com.cohortautomation.dao.CohortDAO;
import com.cohortautomation.dao.UserDAO;
import com.cohortautomation.utilities.PasswordGenerator;
import com.cohortautomation.utilities.UserUtility;

@Controller
public class CoachController {

	@RequestMapping(value="my-cohort", method=RequestMethod.GET)
	public ModelAndView showMyCohort(HttpSession session) {
		if(UserUtility.isAuthenticated(session)) {
			User user = (User) session.getAttribute("user");
			ModelAndView model = new ModelAndView("coach-my-cohort");
			model.addObject("allCohorts", CohortDAO.getAllCohortsForCoach(user));
			return model;
		} else {
			session.setAttribute("nextUrl", "/my-cohort");
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping(value="coach-view-cohort", method=RequestMethod.GET)
	public ModelAndView viewCohort(@RequestParam Map<String, String> request, HttpSession session) {
		String cohortId = request.get("cohortId");
		ModelAndView model = new ModelAndView("coach-view-cohort");
		return model;
	}
	
	@RequestMapping(value="my-meeting", method=RequestMethod.GET)
	public ModelAndView showMyMeeting(HttpSession session) {
		ModelAndView model = new ModelAndView("coach-my-meeting");
		return model;
	}
	
	@RequestMapping(value="my-survey", method=RequestMethod.GET)
	public ModelAndView showMySurvey(HttpSession session) {
		ModelAndView model = new ModelAndView("coach-my-survey");
		return model;
	}
	
	@RequestMapping(value="add-member", method=RequestMethod.POST)
	public ModelAndView addMember(@RequestParam Map<String, String> request, HttpSession session) {
		String cohortID = request.get("cohortID");
		int employeeID = Integer.parseInt(request.get("empID"));
		String firstName = request.get("fname");
		String lastName = request.get("lname");
		String email = request.get("email");

		User user = new User(employeeID, String.valueOf(employeeID), PasswordGenerator.getRandomPassword(8), firstName,
				lastName, email);

		user.setSME(false);
		user.setAdmin(false);
		user.setMember(true);
		user.setMentor(false);
		user.setCoach(false);
		user.setTrainer(false);

		UserDAO.createUser(user, cohortID);
		
		return new ModelAndView("redirect:/view-cohort?cohortID="+cohortID);
	}
}

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
import com.cohortautomation.utilities.PasswordUtil;
import com.cohortautomation.utilities.UserUtility;

@Controller
public class CoachController {
	
	@RequestMapping(value="add-member", method=RequestMethod.POST)
	public ModelAndView addMember(@RequestParam Map<String, String> request, HttpSession session) {
		String cohortID = request.get("cohortID");
		int employeeID = Integer.parseInt(request.get("empID"));
		String firstName = request.get("fname");
		String lastName = request.get("lname");
		String email = request.get("email");

		User user = new User(employeeID, String.valueOf(employeeID), PasswordUtil.getRandomPassword(8), firstName,
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

package com.cohortautomation.controllers;

import com.cohortautomation.dao.UserDAO;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cohortautomation.beans.User;
import com.cohortautomation.utilities.PasswordGenerator;

@Controller
public class AdminController {

	@RequestMapping(value = "/all-sme", method = RequestMethod.GET)
	public String showAllSME(HttpSession session) {
		return "admin-all-SME";
	}

	@RequestMapping(value = "/all-mentor", method = RequestMethod.GET)
	public String showAllMentor(HttpSession session) {
		return "admin-all-Mentors";
	}

	@RequestMapping(value = "/all-trainer", method = RequestMethod.GET)
	public String showAllTrainer(HttpSession session) {
		return "admin-all-Trainer";
	}

	@RequestMapping(value = "/all-coach", method = RequestMethod.GET)
	public String showAllCoach(HttpSession session) {
		return "admin-all-Coach";
	}

	@RequestMapping(value = "/create-trainer", method = RequestMethod.GET)
	public String showCreateTrainerPage() {
		return "admin-create-Trainer";
	}

	@RequestMapping(value = "/create-coach", method = RequestMethod.GET)
	public String showCreateCoachPage() {
		return "admin-create-Coach";
	}

	@RequestMapping(value = "/create-mentor", method = RequestMethod.GET)
	public String showCreateMentorPage() {
		return "admin-create-Mentor";
	}

	@RequestMapping(value = "/create-sme", method = RequestMethod.GET)
	public String showCreateSMEPage() {
		return "admin-create-SME";
	}
	
	@RequestMapping(value = "/create-sme", method = RequestMethod.POST)
	public String createSME(@RequestParam Map<String, String> request, HttpSession session) {
		int employeeID = Integer.parseInt(request.get("empID"));
		String firstName = request.get("fname");
		String lastName = request.get("lname");
		String email = request.get("email");
		
		User user = new User(employeeID, String.valueOf(employeeID),PasswordGenerator.getRandomPassword(8) ,firstName, lastName, email);
		
		user.setSME(true);
		user.setAdmin(false);
		user.setMember(false);
		user.setMentor(false);
		user.setCoach(false);
		user.setTrainer(false);
		
		UserDAO.createUser(user);
		
		return "admin-create-SME";
	}
	
	@RequestMapping(value = "/admin-change-password", method = RequestMethod.GET)
	public String showChangePasswordPage() {
		return "admin-change-password";
	}
}

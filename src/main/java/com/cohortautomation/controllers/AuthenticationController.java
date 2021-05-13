package com.cohortautomation.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cohortautomation.beans.User;
import com.cohortautomation.dao.UserDAO;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginData(@RequestParam Map<String, String> requestData, HttpSession session) {
		String username = requestData.get("username");
		String password = requestData.get("password");

		boolean isValidLogin = UserDAO.validate(username, password);

		if (isValidLogin) {
			User user = UserDAO.getUser(username);
			boolean checkIfFirstLogin = UserDAO.isFirstLogin(user);

			session.setAttribute("user", user);

			if (checkIfFirstLogin) {
				session.setAttribute("message", "You haven't changed your password yet, Please change it.");
			}
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

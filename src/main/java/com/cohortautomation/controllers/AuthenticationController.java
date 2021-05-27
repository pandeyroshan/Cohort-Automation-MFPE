package com.cohortautomation.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
			
			if(session.getAttribute("nextUrl") != null) {
				return "redirect:"+session.getAttribute("nextUrl");
			} else {
				return "redirect:/";
			}
		} else {
			session.setAttribute("loginError", "Invalid Credentials");
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		User user = (User) session.getAttribute("user");
		UserDAO.updateLastLogin(user);
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value="/change-password", method=RequestMethod.GET)
	public String showChangePasswordPage(HttpSession session) {
		return "changePassword";
	}
	
	@RequestMapping(value="/change-password", method=RequestMethod.POST)
	public String showChangePasswordPage(@RequestParam Map<String, String> requestData, HttpSession session) {
		String oldPassword = requestData.get("oldPassword");
		String newPassword = requestData.get("newPassword");
		String confirmNewPassword = requestData.get("confirmNewPassword");
		String keepLoggedIn = requestData.get("keepMeLoggedIn");
		
		if(newPassword.equals(confirmNewPassword)) {
			User user = (User) session.getAttribute("user");
			boolean validate = UserDAO.validate(user.getUsername(), oldPassword);
			
			if(validate) {
				UserDAO.updatePassword(user, newPassword);
				
				if(keepLoggedIn == null) {
					session.invalidate();
					return "redirect:/login";
				} else {
					session.removeAttribute("message");
					user.setFirstLogin(false);
					
					session.removeAttribute("user");
					session.setAttribute("user", user);
					
					UserDAO.uncheckIsFirstLogin(user);

				    return "redirect:/";
				}
			} else {
				// old password mismatch
				session.setAttribute("oldPasswordErrorMessage", "Please provide correct old password.");
			}
		} else {
			// confirm password not same
		}
		
		return "redirect:/change-password";
	}
}

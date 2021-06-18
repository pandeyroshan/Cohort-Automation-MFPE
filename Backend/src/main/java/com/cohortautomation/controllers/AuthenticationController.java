package com.cohortautomation.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.User;
import com.cohortautomation.dao.TokenDAO;
import com.cohortautomation.dao.UserDAO;
import com.cohortautomation.utilities.MailService;
import com.cohortautomation.utilities.PasswordUtil;
import com.cohortautomation.utilities.UserUtility;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "redirect:http://localhost:4200/login";
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
		if(UserUtility.isAuthenticated(session)) {
			return "change-password";
		} else {
			session.setAttribute("nextUrl", "/change-password");
			return "redirect:/login";
		}
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

	@RequestMapping(value="/forgot-password")
	public String showForgotPasswordPage() {
		return "forgot-password";
	}
	
	@RequestMapping(value="/forgot-password", method=RequestMethod.POST)
	public String ForgotPasswordPage(@RequestParam Map<String, String> request) {
		String email = request.get("email");
		
		try {
			String hashedLinkForPasswordReset = PasswordUtil.getHashedLinkForPasswordReset(UserDAO.getOldPassword(email));
			// create a token with this string and send it to email address as well 
			TokenDAO.createToken(email, hashedLinkForPasswordReset);
			MailService.sendPasswordResetLink(email, hashedLinkForPasswordReset);			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return "link-sent";
	}
	
	@RequestMapping(value="/reset-password", method=RequestMethod.GET)
	public ModelAndView showResetPasswordPage(@RequestParam Map<String, String> request) {
		String token = request.get("token");
		
		boolean isValid = TokenDAO.checkTokenValidity(token);
		
		if(isValid) {
			ModelAndView model = new ModelAndView("reset-password");
			model.addObject("token", token);
			return model;
		} else {
			return new ModelAndView("invalid-token");
		}
	}
	
	@RequestMapping(value="/reset-password", method=RequestMethod.POST)
	public ModelAndView resetPassword(@RequestParam Map<String, String> request) {
		String token = request.get("token");
		String password = request.get("password");
		
		String email = TokenDAO.getEmailFromToken(token);
		
		UserDAO.changePassword(email, password);
		
		TokenDAO.deleteToken(email);
		
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value="/api-login", method=RequestMethod.POST)
	@ResponseBody
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String loginAPI(@RequestParam Map<String, String> request) {
		String username = request.get("username");
		String password = request.get("password");
		
		if(UserDAO.validate(username, password)) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("FAILURE");
		}
		
		return "true";
	}
}

package com.cohortautomation.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cohortautomation.utilities.UserPermissions;

@Controller
public class HomepageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomepage(HttpSession session) {
		if (UserPermissions.isAuthenticated(session)) {
			return UserPermissions.getDashboardByRole(session);
		} else {
			return "redirect:login";
		}
	}
}

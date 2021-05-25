package com.cohortautomation.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.utilities.UserUtility;

@Controller
public class HomepageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showHomepage(HttpSession session) {
		if (UserUtility.isAuthenticated(session)) {
			return UserUtility.getDashboardByRole(session);
		} else {
			ModelAndView model = new ModelAndView("redirect:/login");
			return model;
		}
	}
}

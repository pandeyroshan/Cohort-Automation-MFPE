package com.cohortautomation.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.User;
import com.cohortautomation.dao.AttendanceDAO;
import com.cohortautomation.utilities.UserUtility;


@Controller
public class AttendanceController {
	
	@RequestMapping(value="/mark-present", method=RequestMethod.GET)
	public ModelAndView markPresent(HttpSession session) {
		if(UserUtility.isAuthenticated(session)) {
			User user = (User) session.getAttribute("user");
			AttendanceDAO.markPresent(user.getUsername());
			return new ModelAndView("redirect:/");
		} else {
			session.setAttribute("nextUrl", "/mark-present");
			return new ModelAndView("redirect:/login");
		}
	}
}

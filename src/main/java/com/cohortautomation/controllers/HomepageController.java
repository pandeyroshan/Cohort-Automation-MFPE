package com.cohortautomation.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomepage(HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/login";
		}
		return "homepage";
	}
}

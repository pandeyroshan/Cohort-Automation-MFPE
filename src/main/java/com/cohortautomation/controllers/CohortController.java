package com.cohortautomation.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CohortController {
	
	@RequestMapping("/all-cohort")
	public String showAllCohort(HttpSession session) {
		return "admin-all-cohort";
	}
}
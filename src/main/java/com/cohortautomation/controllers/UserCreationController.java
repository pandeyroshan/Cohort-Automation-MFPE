package com.cohortautomation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserCreationController {

	@RequestMapping(value = "/create-member", method = RequestMethod.GET)
	public String showCreateMemberPage() {
		return "createMember";
	}
	
	@RequestMapping(value = "/create-trainer", method = RequestMethod.GET)
	public String showCreateTrainerPage() {
		return "createTrainer";
	}

	@RequestMapping(value = "/create-coach", method = RequestMethod.GET)
	public String showCreateCoachPage() {
		return "createCoach";
	}

	@RequestMapping(value = "/create-mentor", method = RequestMethod.GET)
	public String showCreateMentorPage() {
		return "createMember";
	}

	@RequestMapping(value = "/create-sme", method = RequestMethod.GET)
	public String showCreateSMEPage() {
		return "createMember";
	}
}

package com.cohortautomation.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SMEController {

//	@RequestMapping(value = "/create-survey", method = RequestMethod.POST)
//	public ModelAndView createSurvey(@RequestParam Map<String, String> request, HttpSession session)
//			throws ParseException {
//
//		String surveyName = request.get("surveyName");
//
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
//
//		Date startDate = (Date) formatter.parse(request.get("startDate"));
//		Date endDate = (Date) formatter.parse(request.get("endDate"));
//
//		ModelAndView model = new ModelAndView("redirect:/");
//		return model;
//	}

}
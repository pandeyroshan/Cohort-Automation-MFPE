package com.cohortautomation.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.Question;
import com.cohortautomation.beans.Survey;
import com.cohortautomation.beans.User;
import com.cohortautomation.dao.SurveyDAO;
import com.cohortautomation.utilities.UserUtility;

@Controller
public class SurveyController {

	@RequestMapping(value = "/create-survey", method = RequestMethod.GET)
	public ModelAndView showCreateSurveyPage(@RequestParam Map<String, String> request, HttpSession session) {
		if (UserUtility.isAuthenticated(session)) {
			String cohort = request.get("for");
			ModelAndView model = new ModelAndView("create-survey");
			model.addObject("cohort", cohort);
			return model;
		} else {
			session.setAttribute("nextUrl", "/create-survey");
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(value = "/create-survey", method = RequestMethod.POST)
	public ModelAndView createSurvey(@RequestParam Map<String, String> request, HttpSession session)
			throws ParseException {
		if (UserUtility.isAuthenticated(session)) {
			String cohort = request.get("cohort");
			User user = (User) session.getAttribute("user");
			int totalQuestions = Integer.parseInt(request.get("totalNodes"));
			String surveyName = request.get("surveyName");

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

			Date startDate = (Date) formatter.parse(request.get("startDate"));
			Date endDate = (Date) formatter.parse(request.get("endDate"));

			List<Question> questionList = new ArrayList<Question>();

			for (int i = 0; i < totalQuestions; i++) {
				String QuestionText = request.get("text" + i);
				String QuestionType = request.get("type" + i);

				Question question = new Question(0, QuestionText, QuestionType);

				questionList.add(question);
			}

			Survey survey = new Survey(surveyName,
					startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
					endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
					Integer.parseInt(user.getUsername()), cohort);
			survey.setQuestionsList((ArrayList<Question>) questionList);

			SurveyDAO.createSurvey(survey);

			return new ModelAndView("/create-survey");
		} else {
			session.setAttribute("nextUrl", "/create-survey");
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(value = "/view-survey/{surveyid}", method = RequestMethod.GET)
	public ModelAndView viewSurvey(@PathVariable(value = "surveyid") String id, HttpSession session) {
		if (UserUtility.isAuthenticated(session)) {
			Survey survey = SurveyDAO.getSurvey(Integer.parseInt(id));
			ModelAndView model = new ModelAndView("view-survey");
			model.addObject("survey", survey);
			System.out.println(survey);
			return model;
		} else {
			session.setAttribute("nextUrl", "/view-survey/"+Integer.parseInt(id));
			return new ModelAndView("redirect:/login");
		}
	}
}

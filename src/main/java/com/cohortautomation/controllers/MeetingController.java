package com.cohortautomation.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cohortautomation.beans.Meeting;
import com.cohortautomation.beans.User;
import com.cohortautomation.dao.MeetingDAO;
import com.cohortautomation.utilities.UserUtility;

@Controller
public class MeetingController {
	
	@RequestMapping(value="/create-meeting", method=RequestMethod.POST)
	public ModelAndView createMeeting(@RequestParam Map<String, String> request, HttpSession session) throws ParseException {
		String cohortId = request.get("CohortId");
		String username = request.get("username");
		String meetingName = request.get("meetingName");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

		Date startDatetime = (Date)formatter.parse(request.get("startDateTime"));
		Date endDatetime = (Date)formatter.parse(request.get("endDateTime"));
		
		String meetingLink = request.get("meetingLink");
		
		Meeting meeting = new Meeting(meetingName, "", meetingLink, startDatetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), endDatetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), cohortId);
		meeting.setCreatedBy(username);
		
		MeetingDAO.createMeeting(meeting);
		
		ModelAndView model = new ModelAndView("redirect:/view-cohort?cohortID="+cohortId);
		
		return model;
	}
	
	@RequestMapping(value="/my-meetings", method=RequestMethod.GET)
	public ModelAndView myMeeting(HttpSession session) {
		if(UserUtility.isAuthenticated(session)) {
			User user = (User) session.getAttribute("user");
			List<Meeting> myMeeting = MeetingDAO.getMyMeeting(user.getUsername());
			
			ModelAndView model = new ModelAndView("my-meeting");
			model.addObject("myMeeting", myMeeting);
			return model;
		} else {
			session.setAttribute("nextUrl", "/my-meetings");
			return new ModelAndView("redirect:/login");
		}
	}
}

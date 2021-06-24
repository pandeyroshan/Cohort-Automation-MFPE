package com.cohortautomation.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import com.cohortautomation.beans.Meeting;
import com.cohortautomation.dao.MeetingDAO;

public class MeetingTest {
	
	@Test
	public void checkCreateMeeting() {
		Meeting meeting = new Meeting(1, "Test Meeting", "Writing unit test cases", "http://meet.google.com", LocalDateTime.now(), LocalDateTime.now(), "INTADM21AJ021");
		boolean createMeeting = MeetingDAO.createMeeting(meeting);
		
		assertTrue(createMeeting);
	}
	
	@Test
	public void checkDeleteMeeting() {
		List<Meeting> allMeetingForCohort = MeetingDAO.getAllMeetingForCohort("INTADM21AJ021");
		
		if(allMeetingForCohort.size()>0) {
			Meeting meeting = allMeetingForCohort.get(0);
			
			boolean deleteMeeting = MeetingDAO.deleteMeeting(String.valueOf(meeting.getId()));
			
			assertTrue(deleteMeeting);
		}
		
	}
	
	@Test
	public void checkGetAllMeeting() {
		List<Meeting> allMeetingForCohort = MeetingDAO.getAllMeetingForCohort("INTADM21AJ021");
		
		boolean allTrue = true;
		
		for(Meeting meeting: allMeetingForCohort) {
			if(!meeting.getCohortID().equals("INTADM21AJ021")) {
				allTrue = false;
			}
		}
		
		assertTrue(allTrue);
	}
	
	@Test
	public void checkGetMyMeeting() {
		List<Meeting> myMeeting = MeetingDAO.getMyMeeting("909100");
		
		boolean allTrue = true;
		
		for(Meeting meeting: myMeeting) {
			if(!meeting.getCreatedBy().equals("909100")) {
				allTrue = false;
			}
		}
		
		assertTrue(allTrue);
	}
}

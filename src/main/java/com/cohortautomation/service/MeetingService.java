package com.cohortautomation.service;

import java.util.List;

import com.cohortautomation.beans.Cohort;
import com.cohortautomation.beans.Meeting;

public class MeetingService {

	public static boolean createMeeting(Meeting meeting) {
		return true;
	}

	public static Meeting getMeeting(int id) {
		return null;
	}

	public static List<Meeting> getAllMeeting(Cohort cohort) {
		// this method returns list of Meetings of a given cohort
		return null;
	}

	public static boolean deleteMeeting(Meeting meeting) {
		return true;
	}

	public static boolean editMeeting(Meeting oldMeeting, Meeting newMeeting) {
		return true;
	}
}

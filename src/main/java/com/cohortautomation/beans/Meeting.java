package com.cohortautomation.beans;

import java.time.LocalDateTime;

public class Meeting {
	private String meetingName;
	private String meetingAgenda;
	private String meetingURL;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;

	public Meeting(String meetingName, String meetingAgenda, String meetingURL, LocalDateTime startDateTime,
			LocalDateTime endDateTime) {
		super();
		this.meetingName = meetingName;
		this.meetingAgenda = meetingAgenda;
		this.meetingURL = meetingURL;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public String getMeetingAgenda() {
		return meetingAgenda;
	}

	public void setMeetingAgenda(String meetingAgenda) {
		this.meetingAgenda = meetingAgenda;
	}

	public String getMeetingURL() {
		return meetingURL;
	}

	public void setMeetingURL(String meetingURL) {
		this.meetingURL = meetingURL;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

}

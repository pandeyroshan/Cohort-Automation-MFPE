package com.cohortautomation.beans;

import java.time.LocalDateTime;

public class Meeting {
	private int id;
	private String meetingName;
	private String meetingAgenda;
	private String meetingURL;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private String cohortID;
	private String createdBy;

	public Meeting(int id, String meetingName, String meetingAgenda, String meetingURL, LocalDateTime startDateTime,
			LocalDateTime endDateTime, String cohortID) {
		super();
		this.id = id;
		this.meetingName = meetingName;
		this.meetingAgenda = meetingAgenda;
		this.meetingURL = meetingURL;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.cohortID = cohortID;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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

	public String getCohortID() {
		return cohortID;
	}

	public void setCohortID(String cohortID) {
		this.cohortID = cohortID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Meeting [meetingName=" + meetingName + ", meetingAgenda=" + meetingAgenda + ", meetingURL=" + meetingURL
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", cohortID=" + cohortID + "]";
	}
	
	
}

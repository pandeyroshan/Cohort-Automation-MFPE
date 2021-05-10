package com.cohortautomation.beans;

import java.time.LocalDateTime;
import java.util.Date;

public class Attendance {
	private User user;
	private Date forDate;
	private boolean isPresent;
	private LocalDateTime timestamp;

	public Attendance(User user, Date forDate, boolean isPresent, LocalDateTime timestamp) {
		super();
		this.user = user;
		this.forDate = forDate;
		this.isPresent = isPresent;
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getForDate() {
		return forDate;
	}

	public void setForDate(Date forDate) {
		this.forDate = forDate;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Attendance [user=" + user + ", forDate=" + forDate + ", isPresent=" + isPresent + ", timestamp="
				+ timestamp + "]";
	}

}

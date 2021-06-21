package com.cohortautomation.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Attendance {
	private String username;
	private LocalDate forDate;
	private boolean isPresent;
	private LocalDateTime timestamp;

	public Attendance(String username, LocalDate forDate, boolean isPresent, LocalDateTime timestamp) {
		super();
		this.username = username;
		this.forDate = forDate;
		this.isPresent = isPresent;
		this.timestamp = timestamp;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String username) {
		this.username = username;
	}

	public LocalDate getForDate() {
		return forDate;
	}

	public void setForDate(LocalDate forDate) {
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
		return "Attendance [user=" + username + ", forDate=" + forDate + ", isPresent=" + isPresent + ", timestamp="
				+ timestamp + "]";
	}

}

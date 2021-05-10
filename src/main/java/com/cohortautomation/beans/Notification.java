package com.cohortautomation.beans;

import java.time.LocalDateTime;

public class Notification {
	private int employeeId;
	private String notificationText;
	private LocalDateTime timestamp;
	private boolean isSeen;

	public Notification(int employeeId, String notificationText, LocalDateTime timestamp, boolean isSeen) {
		super();
		this.employeeId = employeeId;
		this.notificationText = notificationText;
		this.timestamp = timestamp;
		this.isSeen = isSeen;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getNotificationText() {
		return notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isSeen() {
		return isSeen;
	}

	public void setSeen(boolean isSeen) {
		this.isSeen = isSeen;
	}

	@Override
	public String toString() {
		return "Notification [employeeId=" + employeeId + ", notificationText=" + notificationText + ", timestamp="
				+ timestamp + ", isSeen=" + isSeen + "]";
	}
	
	
}

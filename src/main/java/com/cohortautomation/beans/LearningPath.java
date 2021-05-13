package com.cohortautomation.beans;

import java.time.LocalDateTime;
import java.util.Date;

public class LearningPath {
	public String name;
	public String description;
	public Date start_date;
	public Date end_date;
	public User createBy;
	public LocalDateTime createdAt;

	public LearningPath(String name, String description, Date start_date, Date end_date, User createBy) {
		super();
		this.name = name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.createBy = createBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "LearningPath [name=" + name + ", description=" + description + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", createBy=" + createBy + ", createdAt=" + createdAt + "]";
	}

}

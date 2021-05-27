package com.cohortautomation.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Survey {
	private String surveyName;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private boolean isDisable;
	private int totalResponse;
	private int createBy;
	private LocalDateTime createAt;
	private ArrayList<Question> questionsList;
	private Cohort cohort;

	public Survey(String surveyName, LocalDateTime startDateTime, LocalDateTime endDateTime, int createBy, Cohort cohort) {
		super();
		this.surveyName = surveyName;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.createBy = createBy;
		this.createAt = java.time.LocalDateTime.now();
		this.questionsList = new ArrayList<Question>();
		this.cohort = cohort;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
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

	public boolean isDisable() {
		return isDisable;
	}

	public void setDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}

	public int getTotalResponse() {
		return totalResponse;
	}

	public void setTotalResponse(int totalResponse) {
		this.totalResponse = totalResponse;
	}

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public ArrayList<Question> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(ArrayList<Question> questionsList) {
		this.questionsList = questionsList;
	}

	public void addQuestion(Question question) {
		questionsList.add(question);
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	@Override
	public String toString() {
		return "Survey [surveyName=" + surveyName + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", isDisable=" + isDisable + ", totalResponse=" + totalResponse + ", createBy=" + createBy
				+ ", createAt=" + createAt + "]";
	}

}

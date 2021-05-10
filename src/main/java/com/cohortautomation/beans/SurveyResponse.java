package com.cohortautomation.beans;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SurveyResponse {
	private Survey survey;
	private HashMap<Question, Answer> answers;
	private User user;
	private LocalDateTime timestamp;

	public SurveyResponse(Survey survey, HashMap<Question, Answer> answers, User user, LocalDateTime timestamp) {
		super();
		this.survey = survey;
		this.answers = answers;
		this.user = user;
		this.timestamp = timestamp;
		this.answers = new HashMap<Question, Answer>();
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public HashMap<Question, Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(HashMap<Question, Answer> answers) {
		this.answers = answers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void addResponse(Question question, Answer answer) {
		answers.put(question, answer);
	}

	@Override
	public String toString() {
		return "SurveyResponse [survey=" + survey + ", answers=" + answers + ", user=" + user + ", timestamp="
				+ timestamp + "]";
	}

}

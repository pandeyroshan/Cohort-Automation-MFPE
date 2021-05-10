package com.cohortautomation.beans;

public class Question {
	private String questionText;
	private String questionType;

	public Question(String questionText, String questionType) {
		super();
		this.questionText = questionText;
		this.questionType = questionType;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@Override
	public String toString() {
		return "Question [questionText=" + questionText + ", questionType=" + questionType + "]";
	}
}

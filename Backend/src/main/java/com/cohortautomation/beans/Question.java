package com.cohortautomation.beans;

public class Question {
	private int id;
	private String questionText;
	private String questionType;

	public Question(int id, String questionText, String questionType) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.questionType = questionType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

package com.cohortautomation.beans;

public class Answer {
	private String answerText;
	private String answerType;

	public Answer(String answerText, String answerType) {
		super();
		this.answerText = answerText;
		this.answerType = answerType;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	@Override
	public String toString() {
		return "Answer [answerText=" + answerText + ", answerType=" + answerType + "]";
	}

}

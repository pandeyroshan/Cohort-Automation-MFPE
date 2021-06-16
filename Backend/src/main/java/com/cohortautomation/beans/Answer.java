package com.cohortautomation.beans;

public class Answer {
	private String answerText;
	private String answerType;
	private int questionID;

	public Answer(String answerText, String answerType, int questionID) {
		super();
		this.answerText = answerText;
		this.answerType = answerType;
		this.questionID = questionID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
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

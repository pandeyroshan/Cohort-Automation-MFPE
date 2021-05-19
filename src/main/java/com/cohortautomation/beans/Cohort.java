package com.cohortautomation.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cohort {
	private String name;
	private String description;
	private Date startdate;
	private int totalWeeks;
	private User coach;
	private User mentor;
	private User SME;
	private User trainer;
	private List<LearningPath> learningPath;

	public Cohort(String name, String description, Date startdate, int totalWeeks) {
		super();
		this.name = name;
		this.description = description;
		this.startdate = startdate;
		this.totalWeeks = totalWeeks;
		this.learningPath = new ArrayList<LearningPath>();
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

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public int getTotalWeeks() {
		return totalWeeks;
	}

	public void setTotalWeeks(int totalWeeks) {
		this.totalWeeks = totalWeeks;
	}

	public User getCoach() {
		return coach;
	}

	public void setCoach(User coach) {
		this.coach = coach;
	}

	public User getMentor() {
		return mentor;
	}

	public void setMentor(User mentor) {
		this.mentor = mentor;
	}

	public User getSME() {
		return SME;
	}

	public void setSME(User sME) {
		SME = sME;
	}

	public List<LearningPath> getLearningPath() {
		return learningPath;
	}

	public void setLearningPath(List<LearningPath> learningPath) {
		this.learningPath = learningPath;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return "Cohort [name=" + name + ", description=" + description + ", startdate=" + startdate + ", totalWeeks="
				+ totalWeeks + ", coach=" + coach + ", mentor=" + mentor + ", SME=" + SME + "]";
	}

}

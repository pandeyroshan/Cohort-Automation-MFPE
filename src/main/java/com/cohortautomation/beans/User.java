package com.cohortautomation.beans;

import java.time.LocalDateTime;

public class User {
	private int employeeId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String personalEmail;
	private String corporateEmail;
	private boolean isMentor;
	private boolean isSME;
	private boolean isTrainer;
	private boolean isCoach;
	private boolean isMember;
	private LocalDateTime lastLogin;
	private String lastIP;
	private boolean isFirstLogin;
	private Cohort cohort;
	private boolean isAdmin;

	public User(int employeeId, String username, String password, String firstName, String lastName,
			String personalEmail) {
		super();
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalEmail = personalEmail;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getCorporateEmail() {
		return corporateEmail;
	}

	public void setCorporateEmail(String corporateEmail) {
		this.corporateEmail = corporateEmail;
	}

	public boolean isMentor() {
		return isMentor;
	}

	public void setMentor(boolean isMentor) {
		this.isMentor = isMentor;
	}

	public boolean isSME() {
		return isSME;
	}

	public void setSME(boolean isSME) {
		this.isSME = isSME;
	}

	public boolean isTrainer() {
		return isTrainer;
	}

	public void setTrainer(boolean isTrainer) {
		this.isTrainer = isTrainer;
	}

	public boolean isCoach() {
		return isCoach;
	}

	public void setCoach(boolean isCoach) {
		this.isCoach = isCoach;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastIP() {
		return lastIP;
	}

	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}

	public boolean isFirstLogin() {
		return isFirstLogin;
	}

	public void setFirstLogin(boolean isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [employeeId=" + employeeId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", personalEmail=" + personalEmail + ", corporateEmail="
				+ corporateEmail + ", isMentor=" + isMentor + ", isSME=" + isSME + ", isTrainer=" + isTrainer
				+ ", isCoach=" + isCoach + ", isMember=" + isMember + ", lastLogin=" + lastLogin + ", lastIP=" + lastIP
				+ ", isFirstLogin=" + isFirstLogin + ", cohort=" + cohort + ", isAdmin=" + isAdmin + "]";
	}
	
	

}

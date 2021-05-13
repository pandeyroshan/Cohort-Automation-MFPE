package com.cohortautomation.dao;

import com.cohortautomation.beans.User;

public class UserDAO {

	public static boolean validate(String username, String password) {
		if (username.equals("admin") && password.equals("admin")) {
			return true;
		}
		return false;
	}

	public static User getUser(String username) {
		return new User(999999, "admin", "admin", "Admin", "Admin", "admin@gmail.com");
	}

	public static boolean isFirstLogin(User user) {
		return true;
	}

	public static boolean updateLastLogin(User user) {
		return true;
	}

	public static boolean uncheckIsFirstLogin(User user) {
		return true;
	}

	public static boolean createUser(User user) {
		return true;
	}

	public static boolean updatePassword(User user, String newPassword) {
		return true;
	}
}

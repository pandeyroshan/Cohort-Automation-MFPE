package com.cohortautomation.utilities;

import javax.servlet.http.HttpSession;

import com.cohortautomation.beans.User;

public class UserPermissions {
	public static boolean isAuthenticated(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return false;
		}
		return true;
	}
	
	public static String getDashboardByRole(HttpSession session) {
		return "admin-dashboard";
	}
}

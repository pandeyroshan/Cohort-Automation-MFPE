package com.cohortautomation.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.cohortautomation.beans.User;
import com.cohortautomation.dao.UserDAO;

public class AuthenticationTest {

	@Test
	public void checkValidLoginTest() {
		boolean validate = UserDAO.validate("admin", "admin");
		assertTrue(validate);
	}

	@Test
	public void checkInvalidLoginTest() {
		boolean validate = UserDAO.validate("admin", "1234");
		assertFalse(validate);
	}

	@Test
	public void checkCorrectUserRole1() {
		User user = UserDAO.getUser("admin");
		assertTrue(user.isAdmin());
	}
	
	@Test
	public void checkCorrectUserRole2() {
		User user = UserDAO.getUser("909102");
		assertFalse(user.isAdmin());
	}
	
	@Test
	public void checkUpdatePassword() {
		User user = UserDAO.getUser("admin");
		boolean updatePassword = UserDAO.updatePassword(user, "123456");
		
		if(updatePassword) {
			boolean validate = UserDAO.validate("admin", "123456");
			assertTrue(validate);
		}
		
		UserDAO.updatePassword(user, "admin");
	}
}
package com.cohortautomation.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.cohortautomation.beans.Attendance;
import com.cohortautomation.dao.AttendanceDAO;

public class AttendanceTest {
	
	@Test
	public void checkAttendance() {
		Boolean isPresentToday = AttendanceDAO.isPresent("909102");
		
		if(isPresentToday == false) {
			boolean markPresent = AttendanceDAO.markPresent("909102");
			
			if(markPresent) {
				Boolean present = AttendanceDAO.isPresent("909102");
				
				assertTrue(present);
			}
		}
	}

	@Test
	public void checkAllAttendance() {
		List<Attendance> allAttendance = AttendanceDAO.getAllAttendance("909102");
		
		boolean allTrue = true;
		
		for(Attendance attendance : allAttendance) {
			if(!attendance.getUser().equals("909102")) {
				allTrue = false;
			}
		}
		
		assertTrue(allTrue);
	}
}

package com.cohortautomation.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {
	public static void main(String[] args) {
		Result runClasses = JUnitCore.runClasses(TestSuite.class);
		
		for(Failure failure : runClasses.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println("All Test Cases Passed with status "+runClasses.wasSuccessful());
	}
}

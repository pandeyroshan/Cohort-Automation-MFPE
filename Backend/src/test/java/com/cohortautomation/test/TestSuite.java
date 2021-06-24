package com.cohortautomation.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AuthenticationTest.class, AttendanceTest.class, MeetingTest.class})
public class TestSuite {

}

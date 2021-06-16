package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cohortautomation.beans.Meeting;
import com.cohortautomation.beans.User;

public class MeetingDAO {

	// return all the meeting create by a user
	public static List<Meeting> getMyMeeting(String createdBy) {
		Connection con = DBConnection.getConnection();
		List<Meeting> meetingList = new ArrayList<Meeting>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select meeting_link, start_datetime, end_datetime, heading, cohort, id from meeting where created_by=?");
			stmt.setString(1, createdBy);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Meeting meeting = new Meeting(result.getInt(6), result.getString(4), "", result.getString(1),
						result.getTimestamp(2).toLocalDateTime(), result.getTimestamp(3).toLocalDateTime(),
						result.getString(5));
				meeting.setCreatedBy(createdBy);
				meetingList.add(meeting);
			}

			return meetingList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// returns all the meeting for a cohort
	public static List<Meeting> getAllMeetingForCohort(String cohortId) {
		Connection con = DBConnection.getConnection();
		List<Meeting> meetingList = new ArrayList<Meeting>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select meeting_link, start_datetime, end_datetime, heading, created_by, id from meeting where cohort=?");
			stmt.setString(1, cohortId);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Meeting meeting = new Meeting(result.getInt(6), result.getString(4), "", result.getString(1),
						result.getTimestamp(2).toLocalDateTime(), result.getTimestamp(3).toLocalDateTime(), cohortId);
				meeting.setCreatedBy(result.getString(5));
				meetingList.add(meeting);
			}

			return meetingList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static boolean createMeeting(Meeting meeting) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into meeting (meeting_link, start_datetime, end_datetime, is_cancelled, note, requires_message_alert, heading, cohort, created_by) values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, meeting.getMeetingURL());
			stmt.setTimestamp(2, java.sql.Timestamp.valueOf(meeting.getStartDateTime().now()));
			stmt.setTimestamp(3, java.sql.Timestamp.valueOf(meeting.getEndDateTime().now()));
			stmt.setInt(4, 0);
			stmt.setString(5, "");
			stmt.setInt(6, 0);
			stmt.setString(7, meeting.getMeetingName());
			stmt.setString(8, meeting.getCohortID());
			stmt.setString(9, meeting.getCreatedBy());

			int result = stmt.executeUpdate();

			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean deleteMeeting(String meetingId) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from meeting where id=?");
			stmt.setInt(1, Integer.parseInt(meetingId));

			int result = stmt.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}
}
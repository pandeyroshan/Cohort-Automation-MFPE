package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cohortautomation.beans.Question;
import com.cohortautomation.beans.Survey;

public class SurveyDAO {
	public static boolean createSurvey(Survey survey) {
		Connection con = DBConnection.getConnection();

		try {
			String[] returnId = {"id"};
			PreparedStatement stmt = con.prepareStatement(
					"insert into survey (survey_name, survey_start_timestamp, survey_end_timestamp, is_disable, total_response, created_by_id, created_at, cohort) values(?,?,?,?,?,?,?,?)", returnId);
			stmt.setString(1, survey.getSurveyName());
			stmt.setTimestamp(2, java.sql.Timestamp.valueOf(survey.getStartDateTime()));
			stmt.setTimestamp(3, java.sql.Timestamp.valueOf(survey.getEndDateTime()));
			stmt.setInt(4, 0);
			stmt.setInt(5, 0);
			stmt.setString(6, String.valueOf(survey.getCreateBy()));
			stmt.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			stmt.setString(8, survey.getCohort());
			
			int result1 = stmt.executeUpdate();
			
			int surveyId = -1;
			ResultSet result = stmt.getGeneratedKeys();
			
			if(result.next()) {
				surveyId = result.getInt(1);
			}
			
			PreparedStatement stmt2 = con.prepareStatement("insert into question (question_text, is_text_type, is_number_type, survey_id) values(?,?,?,?)");

			for(Question question: survey.getQuestionsList()) {
				stmt2.setString(1, question.getQuestionText());
				stmt2.setString(4, String.valueOf(surveyId));
				
				if(question.getQuestionType().equals("text")) {
					stmt2.setInt(2, 1);
					stmt2.setInt(3, 0);
				} else if(question.getQuestionType().equals("number")) {
					stmt2.setInt(2, 0);
					stmt2.setInt(3, 1);
				} else if(question.getQuestionType().equals("date")) {
					stmt2.setInt(2, 0);
					stmt2.setInt(3, 0);
				} else {
					stmt2.setInt(2, 1);
					stmt2.setInt(3, 0);
				}
				
				stmt2.executeUpdate();
			}

			return true;
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
	
	public static List<Survey> getMySurveys(String createdBy){
		return null;
	}
	
	public static List<Survey> getSurveyForCohort(String cohort){
		return null;
	}
	
	public static Survey getSurvey(int id) {
		return null;
	}
	
	public static boolean deleteSurvey(int id) {
		return true;
	}
}

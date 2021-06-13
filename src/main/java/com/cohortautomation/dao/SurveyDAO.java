package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cohortautomation.beans.Question;
import com.cohortautomation.beans.Survey;

public class SurveyDAO {
	public static boolean createSurvey(Survey survey) {
		Connection con = DBConnection.getConnection();

		try {
			String[] returnId = { "id" };
			PreparedStatement stmt = con.prepareStatement(
					"insert into survey (survey_name, survey_start_timestamp, survey_end_timestamp, is_disable, total_response, created_by_id, created_at, cohort) values(?,?,?,?,?,?,?,?)",
					returnId);
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

			if (result.next()) {
				surveyId = result.getInt(1);
			}

			PreparedStatement stmt2 = con.prepareStatement(
					"insert into question (question_text, is_text_type, is_number_type, survey_id) values(?,?,?,?)");

			for (Question question : survey.getQuestionsList()) {
				stmt2.setString(1, question.getQuestionText());
				stmt2.setString(4, String.valueOf(surveyId));

				if (question.getQuestionType().equals("text")) {
					stmt2.setInt(2, 1);
					stmt2.setInt(3, 0);
				} else if (question.getQuestionType().equals("number")) {
					stmt2.setInt(2, 0);
					stmt2.setInt(3, 1);
				} else if (question.getQuestionType().equals("date")) {
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

	public static List<Survey> getMySurveys(String createdBy) {
		List<Survey> allSurvey = new ArrayList<Survey>();

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement("select * from survey where created_by_id = ?");
			stmt.setString(1, createdBy);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Survey survey = new Survey(result.getString(2), result.getTimestamp(3).toLocalDateTime(),
						result.getTimestamp(4).toLocalDateTime(), result.getInt(7), result.getString(9));
				survey.setCreateAt(result.getTimestamp(8).toLocalDateTime());
				survey.setTotalResponse(result.getInt(6));
				survey.setId(result.getInt(1));

				allSurvey.add(survey);
			}
			
			System.out.println(allSurvey);

			return allSurvey;
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

	public static List<Survey> getSurveyForCohort(String cohort) {
		List<Survey> allSurvey = new ArrayList<Survey>();

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement("select * from survey where cohort = ?");
			stmt.setString(1, cohort);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Survey survey = new Survey(result.getString(2), result.getTimestamp(3).toLocalDateTime(),
						result.getTimestamp(4).toLocalDateTime(), result.getInt(7), result.getString(9));
				survey.setCreateAt(result.getTimestamp(8).toLocalDateTime());
				survey.setTotalResponse(result.getInt(6));
				survey.setId(result.getInt(1));

				allSurvey.add(survey);
			}

			return allSurvey;
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

	public static Survey getSurvey(int id) {
		Connection con = DBConnection.getConnection();
		try {
			System.out.println("INSIDE DAO: Searching for Survey with id "+id);
			PreparedStatement stmt = con.prepareStatement("select * from survey where id=?");
			stmt.setInt(1, id);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				Survey survey = new Survey(result.getString(2), result.getTimestamp(3).toLocalDateTime(),
						result.getTimestamp(4).toLocalDateTime(), result.getInt(7), result.getString(9));
				survey.setCreateAt(result.getTimestamp(8).toLocalDateTime());
				survey.setTotalResponse(result.getInt(6));
				survey.setId(result.getInt(1));

				PreparedStatement stmt2 = con.prepareStatement("select * from question where survey_id = ?");
				stmt2.setInt(1, id);

				ResultSet result2 = stmt2.executeQuery();

				List<Question> questions = new ArrayList<Question>();

				while (result2.next()) {
					if (result2.getInt(3) == 1) {
						Question question = new Question(result2.getInt(1), result2.getString(2), "text");
						questions.add(question);
					} else if (result2.getInt(4) == 1) {
						Question question = new Question(result2.getInt(1), result2.getString(2), "number");
						questions.add(question);
					} else if (result2.getInt(3) == 0 && result2.getInt(4) == 0) {
						Question question = new Question(result2.getInt(1), result2.getString(2), "date");
						questions.add(question);
					}
				}
				
				survey.setQuestionsList((ArrayList<Question>) questions);
				
				System.out.println("Got it: "+survey);

				return survey;
			}
			return null;
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

	public static boolean deleteSurvey(int id) {
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("delete from survey where id=?");
			stmt.setInt(1, id);
			int result1 = stmt.executeUpdate();
			
			PreparedStatement stmt2 = con.prepareStatement("delete from question where survey_id=?");
			stmt2.setInt(1, id);
			
			int result2 = stmt2.executeUpdate();
			
			if(result1 >0 && result2>0) {
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

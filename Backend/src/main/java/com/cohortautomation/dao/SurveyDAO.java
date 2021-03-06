package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cohortautomation.beans.Answer;
import com.cohortautomation.beans.Question;
import com.cohortautomation.beans.Survey;
import com.cohortautomation.beans.User;

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
			
			//(allSurvey);

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
			//("INSIDE DAO: Searching for Survey with id "+id);
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
				
				//("Got it: "+survey);

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
	
	public static boolean addSurveyResponse(int surveyId, List<Answer> answerList, String username) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into answer (answer_text, is_text_type, is_number_type, answered_by_id, question_id, survey_id) values(?,?,?,?,?,?)");
			
			for(Answer answer: answerList) {
				stmt.setString(1, answer.getAnswerText());
				
				if(answer.getAnswerType().equals("t")) {
					stmt.setInt(2, 1);
					stmt.setInt(3, 0);
				} else if(answer.getAnswerType().equals("n")) {
					stmt.setInt(2, 0);
					stmt.setInt(3, 1);
				} else if(answer.getAnswerType().equals("d")) {
					stmt.setInt(2, 0);
					stmt.setInt(3, 0);
				}
				stmt.setInt(4, Integer.parseInt(username));
				stmt.setInt(5, answer.getQuestionID());
				stmt.setInt(6, surveyId);
				
				stmt.executeUpdate();
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
	
	public static boolean checkIfAlreadyFilled(int surveyId, String username) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from answer where answered_by_id = ? and survey_id = ?");
			stmt.setInt(1, Integer.parseInt(username));
			stmt.setInt(2, surveyId);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
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
	
	public static HashMap<String, String> getSurveyResponse(int surveyId, String username) {
		Connection con = DBConnection.getConnection();
		HashMap<String, String> response = new HashMap<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement("select answer_text from answer where question_id = ? and survey_id = ? and answered_by_id = ?");
			
			ArrayList<Question> questionsList = SurveyDAO.getSurvey(surveyId).getQuestionsList();
			
			stmt.setInt(2, surveyId);
			stmt.setInt(3, Integer.parseInt(username));
			
			for(Question question: questionsList) {
				stmt.setInt(1, question.getId());
				
				ResultSet result = stmt.executeQuery();
				
				if(result.next()) {
					response.put(question.getQuestionText(), result.getString(1));
				}
			}
			
			return response;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static HashMap<String, HashMap<String, String>> getAllSurveyResponse(int surveyId)
	{
		HashMap<String, HashMap<String, String>> allResponse = new HashMap<String, HashMap<String, String>>();
		
		Survey survey = SurveyDAO.getSurvey(surveyId);
		String cohort = survey.getCohort();
		
		List<User> allMembersForCohort = CohortDAO.getAllMembersForCohort(cohort);
		
		for(User user: allMembersForCohort) {
			
			HashMap<String, String> surveyResponse = SurveyDAO.getSurveyResponse(surveyId, user.getUsername());
			
			if(surveyResponse.size()>0) {
				allResponse.put(user.getUsername(), surveyResponse);
			}
		}
		
		return allResponse;
	}
}
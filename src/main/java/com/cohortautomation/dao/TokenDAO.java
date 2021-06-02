package com.cohortautomation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenDAO {
	public static boolean createToken(String email, String hashedLinkForPasswordReset) {
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("insert into tokens (email, token) values (?,?)");
			stmt.setString(1, email);
			stmt.setString(2, hashedLinkForPasswordReset);
			
			int result = stmt.executeUpdate();
			
			if(result>0) {
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
	
	public static boolean checkTokenValidity(String token) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select token from tokens where token=?");
			stmt.setString(1, token);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				if(result.getString(1).equals(token)) {
					return true;
				} else {
					return false;
				}
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
	
	public static String getEmailFromToken(String token) {
		Connection con = DBConnection.getConnection();
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select email from tokens where token = ?");
			stmt.setString(1, token);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				return result.getString(1);
			} else {
				return "";
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
		
		return "";
	}
}

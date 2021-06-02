package com.cohortautomation.utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cohortautomation.beans.Meeting;
import com.cohortautomation.beans.SurveyResponse;
import com.cohortautomation.beans.User;

public class MailService {
	static String to = "pandeyroshan556@gmail.com";
	static String from = "roshanpandey11022000@gmail.com";
	static String host = "smtp.gmail.com";
	static Properties properties = System.getProperties();
	static Session session;
	MimeMessage message;

	public static void setup() {
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("roshanpandey11022000@gmail.com", "SomeThing@Inn0vative");

			}

		});

		session.setDebug(true);
	}

	public static void sendCredentials(User user) {
		setup();

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getPersonalEmail()));

			message.setSubject("Login Credentials for Cohort Automation");

			message.setText("Hi " + user.getFirstName()
					+ ", welcome to cohort automation. Here are your login details - \nUsername: " + user.getUsername()
					+ "\nPassword: " + user.getPassword()
					+ "\nUse these crendentials to login, and please change your password immediately after you first login.\nRegards,\nTeam Cohort Automation");

			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void sendPasswordResetLink(String email, String token) {
		setup();
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			message.setSubject("Reset password link for Cohort Automation");
			
			message.setText("Hi,\n\n You have requested the password reset link for your account. Please follow link given below.\n\n"
					+"Link: "+ "http://localhost:8080/reset-password?token="+token);
			
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void sendMeetingAlert(Meeting meeting) {
		// this function will send the meeting alerts
	}
	
	public static void sendSurveyResponse(SurveyResponse surveyResponse) {
		// this function will send the survey response filled by a user
	}
}
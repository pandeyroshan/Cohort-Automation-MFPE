package com.cohortautomation.utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

	public static void main(String[] args) {
		User user = new User(909102, "909102", "Linux@123", "Roshan", "Pandey", "pandeyroshan556@gmail.com");

		sendCredentials(user);
	}
}
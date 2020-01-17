package com.technoevans.sendingFormData;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.omg.CORBA.Request;

public class Mailer {
	public static void send(String to, String name, String email, String subject, String message) throws Exception {

		String user = "biharikiranranjan@gmail.com";// change accordingly
		String pass = "Kiran@1996ranjan";

		//Get the session object	
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");// change accordingly
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});

		try {
			MimeMessage mimemessage = new MimeMessage(session);
			mimemessage.setFrom(new InternetAddress(user));
			mimemessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimemessage.setSubject(subject);
			mimemessage.setText(name + " " + email + " " + message);
			Transport.send(mimemessage);
		} catch (MessagingException e) {
			System.out.println("Something is wrong!!! PLease try again something!!!");
			throw new RuntimeException(e);
		}
		System.out.println("Message send successfully");
	}
}

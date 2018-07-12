package com.bridgelabzservlet.controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private static String USER_NAME = "sameersaurabh9314";  // GMail user name (just the part before "@gmail.com")
	private static String PASSWORD = "************"; // GMail password

	public static void sendMail(String email,String password) {
		 String RECIPIENT = email;
		 String from = USER_NAME;
		 String pass = PASSWORD;
		 String to = RECIPIENT; // list of recipient email addresses
		 String subject = "Password Recovry Mail";
		 String body = "Your password is "+password;
	
		 Properties props = System.getProperties();
		  String host = "smtp.gmail.com";

		    props.put("mail.smtp.starttls.enable", "true");

		    props.put("mail.smtp.ssl.trust", host);
		    props.put("mail.smtp.user", from);
		    props.put("mail.smtp.password", pass);
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");

		    Session session = Session.getDefaultInstance(props);
		    MimeMessage message = new MimeMessage(session);

		    try {
		        message.setFrom(new InternetAddress(from));
		        
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		            message.setSubject(subject);
		            message.setText(body);
		            
		            Transport transport = session.getTransport("smtp");
		            
		            transport.connect(host, from, pass);
		            transport.sendMessage(message, message.getAllRecipients());
		            transport.close();
		            
		        }
		    catch (AddressException ae) {
		        ae.printStackTrace();
		    }
		    catch (MessagingException me) {
		        me.printStackTrace();
		    }
		    }
		   } 

package com.app.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {

	public static void send(String from,String password,String to,String sub,String msg){  
		//Get properties object    
		Properties props = new Properties();    
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465");    
		//get Session   
		Session session = Session.getDefaultInstance(props,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(from,password);  
			}    
		});    
		//compose message    
		try {    
			MimeMessage message = new MimeMessage(session);    
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
			message.setSubject(sub);    
			message.setText(msg);    
			//send message  
			Transport.send(message);    
		} catch (MessagingException e) {throw new RuntimeException(e);}    

	}

	public static void sendAttachment(String to) {
		
		final String user="technoidentity.vitalz@gmail.com";  
		final String password="technoidentity12345";  

		//--------1. get the session object--------     
		Properties properties = System.getProperties();  
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");  
		
		properties.put("mail.smtp.socketFactory.port", "465");    
		properties.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		properties.put("mail.smtp.auth", "true");    
		properties.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(properties,  
				new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(user,password);  
			}  
		});  

		//--------2. compose message--------     
		try{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(user));  
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			message.setSubject("Message Aleart");  

			//--------3. create MimeBodyPart object and set your message text--------     
			BodyPart messageBodyPart1 = new MimeBodyPart();  
			messageBodyPart1.setText("This is message body");  

			//--------4. create new MimeBodyPart object and set DataHandler object to this object--------      
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

			String filename = "P:\\Project\\Spring Boot Microservice\\allEvents.pdf";//change accordingly  
		
			DataSource source = new FileDataSource(filename);  
			messageBodyPart2.setDataHandler(new DataHandler(source));  
			messageBodyPart2.setFileName(filename);  


			//5) create Multipart object and add MimeBodyPart objects to this object      
			Multipart multipart = new MimeMultipart();  
			multipart.addBodyPart(messageBodyPart1);  
			multipart.addBodyPart(messageBodyPart2);  

			//6) set the multiplart object to the message object  
			message.setContent(multipart );  

			//7) send message  
			Transport.send(message);  

		}catch (MessagingException ex) {ex.printStackTrace();} 
		
	} 
}

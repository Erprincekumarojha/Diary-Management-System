package com.app.service;

import java.util.List;
import java.util.Scanner;

import com.app.util.EmailUtil;

public class EmailService {
	public static Scanner sc = new Scanner(System.in);
	public static void sendEmail(String to, String id) {
		EmailUtil.send("technoidentity.vitalz@gmail.com","technoidentity12345",to,
				"Diary Application","Diary Records with Id "+id+" deleted successfully...");
		
		
		System.out.println("Record deleted successfully and email sent to "+to);
	}

	
	public static void sendEmailWithAttachment() {
		System.out.println("Email: ");
		String toEmail = sc.nextLine();
		
		EmailUtil.sendAttachment(toEmail);
		
		System.out.println("File allEvents.pdf sent with  records to "+toEmail);
	}
}

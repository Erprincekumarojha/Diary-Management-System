package com.app.service;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.app.model.DiaryEvent;

public class RemoveService {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void remove(List<DiaryEvent> diaryEvent) {
		
		System.out.println("Remove event by Id: ");
		String id = sc.nextLine();
		
		ListIterator<DiaryEvent> itr=diaryEvent.listIterator();
		while(itr.hasNext()) {
			DiaryEvent event=itr.next();
			 if(event.getId().equals(id)){
				 String toEmail = event.getEmail();
				 itr.remove();
				 EmailService.sendEmail(toEmail,id);
			 }
			
		}
	}

}

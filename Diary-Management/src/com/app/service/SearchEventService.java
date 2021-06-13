package com.app.service;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.app.model.DiaryEvent;

public class SearchEventService {
	
	public static Scanner sc = new Scanner(System.in);

	public static void find(List<DiaryEvent> diaryEvent) {
		
		System.out.println("Enter search text: ");
		String input = sc.nextLine();
		
		System.out.println("Event ID  |  Title   |  Date  |  Address 1   |  Contact Number(Mobile)");
		System.out.println("--------     -----      ----     ---------      ----------------------");
		ListIterator<DiaryEvent> itr=diaryEvent.listIterator();
		while(itr.hasNext()) {
			 DiaryEvent event=itr.next();
			 if(event.getTitle().contains(input) || event.getEmail().contains(input) || event.getDate().contains(input))
				 System.out.println(event.getId()+"   "+event.getTitle()+"  "+event.getDate()+"   "+event.getAddress().getAddressline1()+"  "+event.getContactInfo().getMobile());
			
		}
		
	}
}

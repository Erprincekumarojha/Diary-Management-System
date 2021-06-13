package com.app.service;

import java.util.List;
import java.util.ListIterator;

import com.app.model.DiaryEvent;

public class ListOfEventService {
	
	
	public static void displayListOfEvents(List<DiaryEvent> diaryEvent) {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Event ID  |  Title   |  Date  |  Address 1   |  Contact Number(Mobile)");
		System.out.println("----------------------------------------------------------------------------");
		ListIterator<DiaryEvent> itr=diaryEvent.listIterator();
		while(itr.hasNext()) {
			 DiaryEvent event=itr.next();
			 System.out.println(event.getId()+"      | "+event.getTitle()+"    | "+event.getDate()+"  | "+event.getAddress().getAddressline1()+"         | "+event.getContactInfo().getMobile());
		}
	}
}

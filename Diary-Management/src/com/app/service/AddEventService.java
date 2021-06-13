package com.app.service;
import java.util.Scanner;
import com.app.model.Address;
import com.app.model.ContactInfo;
import com.app.model.DiaryEvent;
import com.app.util.ValidateUtil;

public class AddEventService {
	public static Scanner sc=new Scanner(System.in);


	public static DiaryEvent AddEvent(int id) {

		DiaryEvent event=new DiaryEvent();
		Address address=new Address();
		ContactInfo contact=new ContactInfo();
		
		event.setId(String.format("E%03d", id));
		sc.nextLine();
		System.out.print("Title :");
		event.setTitle(sc.nextLine());

		System.out.print("Email :");
		String email = ValidateUtil.validateEmail();
		event.setEmail(email);


		System.out.print("Date :");
		String date = ValidateUtil.validateDate();
		event.setDate(date);
		
		System.out.print("Description :");
		event.setDescription(sc.nextLine());


		System.out.println("Address");
		System.out.print("Address line 1 :");
		address.setAddressline1(sc.nextLine());
		System.out.print("Address line 2 :");
		address.setAddressline2(sc.nextLine());
		
		System.out.print("City :");
		String city = ValidateUtil.validateCity();
		address.setCity(city);
		System.out.print("State :");
		String state = ValidateUtil.validateState();
		address.setState(state);


		System.out.println("Contact Info");
		System.out.print("Telephone :");
		String telephone = ValidateUtil.validateTelephone();
		contact.setTelephone(telephone);
		System.out.print("Mobile :");
		String mobile = ValidateUtil.validateMobile();
		contact.setMobile(mobile);

		event.setAddress(address);
		event.setContactInfo(contact);

		return event;
	}

}

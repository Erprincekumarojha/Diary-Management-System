package com.app.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateUtil {
	public static Scanner sc = new Scanner(System.in);


	public static String validateEmail() {
		String email=null;
		boolean flag = true;

		while(flag) {
			email = sc.nextLine();
			boolean isEmail = Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", email);
			if(isEmail) {
				flag = false;
				return email;
			}
			else 
				System.err.println("Wrong Email");
		}
		return email;
	}

	public static String validateDate() {
		String date = null;
		boolean flag = true;
		
		while(flag) {
			date = sc.nextLine();
			boolean isDate = Pattern.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$", date);
			if(isDate) {
				flag = false;
				return date;
			}
			else
				System.err.println("Wrong Date");
		}
		return date;
	}

	public static String validateCity() {
		String city = null;
		boolean flag = true;
		
		while(flag) {
			city = sc.nextLine();
			boolean isCity = Pattern.matches("[a-zA-Z]+", city);
			if(isCity) {
				flag = false;
				return city;
			}
			else
				System.err.println("Wrong City");
		}
		return city;
	}

	public static String validateState() {
		String state = null;
		boolean flag = true;
		
		while(flag) {
			state = sc.nextLine();
			boolean isState = Pattern.matches("[a-zA-Z]+", state);
			if(isState) {
				flag = false;
				return state;
			}
			else
				System.err.println("Wrong State");
		}
		return state;
	}

	public static String validateTelephone() {
		String telephone = null;
		boolean flag = true;
		
		while(flag) {
			telephone = sc.nextLine();
			boolean isTelephone = Pattern.matches("^0[2-7]{2,5}[1-6][0-9]{5,7}$", telephone);
			if(isTelephone) {
				flag = false;
				return telephone;
			}
			else
				System.err.println("Wrong Telephone");
		}
		return telephone;
	}

	public static String validateMobile() {
		String mobile = null;
		boolean flag = true;
		
		while(flag) {
			mobile = sc.nextLine();
			boolean isMobile =Pattern.matches("^[7-9][0-9]{9}$", mobile);
			if(isMobile) {
				flag = false;
				return mobile;
			}
			else
				System.err.println("Wrong Mobile");
		}
		return mobile;
	}
}
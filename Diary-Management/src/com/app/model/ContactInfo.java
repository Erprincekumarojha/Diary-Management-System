package com.app.model;

public class ContactInfo {
	
	private String telephone;
	private String mobile;
	
	
	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	
	public ContactInfo() {
		super();
	}


	public ContactInfo(String telephone, String mobile) {
		super();
		this.telephone = telephone;
		this.mobile = mobile;
	}
	
	
	
}

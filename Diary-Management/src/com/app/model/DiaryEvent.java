package com.app.model;

public class DiaryEvent {
	private String id;
	private String title;
	private String email;
	private String date;

	private String description;
	
	private Address address;
	
	private ContactInfo contactInfo;

	public DiaryEvent() {
		super();
	}

	public DiaryEvent(String id, String title, String email, String date, String description, Address address,
			ContactInfo contactInfo) {
		super();
		this.id = id;
		this.title = title;
		this.email = email;
		this.date = date;
		this.description = description;
		this.address = address;
		this.contactInfo = contactInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}

package com.Sapi3DTourMongo.Sapi3DTourMongo.respons;

import java.util.Date;

public class UserDataWithIdResponse {
	
	private String username;
	
	private Date createdAt;

	private String emailAddress;

	private String password;
	
	private String phoneNumber;
	
	public UserDataWithIdResponse(String username, Date createdAt, String emailAddress, String password, String phoneNumber )
	{
		this.username = username;
		this.createdAt = createdAt;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}

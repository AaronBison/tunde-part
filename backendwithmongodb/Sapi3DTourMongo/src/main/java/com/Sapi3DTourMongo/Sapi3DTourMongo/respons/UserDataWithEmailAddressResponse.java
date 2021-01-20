package com.Sapi3DTourMongo.Sapi3DTourMongo.respons;

public class UserDataWithEmailAddressResponse {
	
	private String _id;
	
	private String username;

	private String emailAddress;
	
	private String phoneNumber;

	public UserDataWithEmailAddressResponse(String _id, String username, String emailAddress, String phoneNumber) {
		this._id = _id;
		this.username = username;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.bson.types.ObjectId;

public class UserDataUpdateRequest {
	
	@NotBlank
	@NotEmpty
	private ObjectId _id;
	
	@NotNull
    @NotEmpty
	private String username;
	
	@NotNull
    @NotEmpty
	@Pattern(regexp="^(.+)@(.+)$")
	private String emailAddress;
	
	@NotNull
    @NotEmpty
	@Pattern(regexp="^\\d{10}$")
	private String phoneNumber;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
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

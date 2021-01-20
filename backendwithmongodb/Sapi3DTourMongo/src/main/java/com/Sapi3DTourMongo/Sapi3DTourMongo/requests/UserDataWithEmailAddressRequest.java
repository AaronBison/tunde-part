package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserDataWithEmailAddressRequest {
	
	@NotBlank
	@NotEmpty
	private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}

package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoginRequest {
	
	@NotNull
    @NotEmpty
	@Pattern(regexp="^(.+)@(.+)$")
	private String emailAddress;

	@NotNull
    @NotEmpty
    @Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$")
	@NotBlank
	private String password;

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
	
}

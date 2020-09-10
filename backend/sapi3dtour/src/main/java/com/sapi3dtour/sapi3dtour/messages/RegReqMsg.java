package com.sapi3dtour.sapi3dtour.messages;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RegReqMsg implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	@NotNull
    @NotEmpty
	private String fullName;
	
	@NotNull
    @NotEmpty
	@Pattern(regexp="^(.+)@(.+)$")
	private String emailAddress;
	
	@NotNull
    @NotEmpty
	@Pattern(regexp="^\\d{10}$")
	private String phoneNumber;
	
	@NotNull
    @NotEmpty
	private String authority;
	
	public RegReqMsg() {
		
	}
	
	public RegReqMsg(String fullName, String emailAddress, Timestamp createdAt, String phoneNumber, String authority) {
		this.setAuthority(authority);
		this.setFullName(fullName);
		this.setPhoneNumber(phoneNumber);
		this.setEmailAddress(emailAddress);
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}

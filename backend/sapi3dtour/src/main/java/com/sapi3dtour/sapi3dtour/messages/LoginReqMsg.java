package com.sapi3dtour.sapi3dtour.messages;

import java.io.Serializable;

public class LoginReqMsg implements Serializable {
	
	private static final long serialVersionUID = 5926468583005150707L;
	
	//@Pattern(regexp="^(.+)@(.+)$")
	private String emailAddress;
	
	//@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}")  
	private String password;
	
	public LoginReqMsg() {
		
	}
	
	public LoginReqMsg(String emailAddress, String password) {
		this.setEmailAddress(emailAddress);
		this.setPassword(password);
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
}

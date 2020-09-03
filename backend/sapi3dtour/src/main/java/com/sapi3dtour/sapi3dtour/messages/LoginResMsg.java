package com.sapi3dtour.sapi3dtour.messages;

import java.io.Serializable;

public class LoginResMsg implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	
	private Long id;
	
	public LoginResMsg (String jwttoken, Long id) {
		
		this.id = id;
		this.jwttoken = jwttoken;
	}
	
	public String getToken() {
		return this.jwttoken;
	}
	
	public Long getId() {
		return this.id;
	}
}

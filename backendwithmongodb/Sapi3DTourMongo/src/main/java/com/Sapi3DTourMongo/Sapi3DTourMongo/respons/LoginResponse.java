package com.Sapi3DTourMongo.Sapi3DTourMongo.respons;

import java.util.List;

public class LoginResponse {
	
	private String token;
	private String id;
	private List<String> roles;

	public LoginResponse(String accessToken, String id, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getRoles() {
		return roles;
	}

}

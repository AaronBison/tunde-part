package com.Sapi3DTourMongo.Sapi3DTourMongo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Id
	private ObjectId _id;

	private String username;
	
	private Date createdAt;

	private String emailAddress;

	private String password;
	
	private String phoneNumber;

	@DBRef
	private Set<Role> roles = new HashSet<>();
	
	public User() {}
	
	public User(String username, Date createdAt, String emailAddress, String password, String phoneNumber) {
		this.username = username;
		this.createdAt = createdAt;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public User(String username, Date createdAt, String emailAddress, String phoneNumber) {
		this.username = username;
		this.createdAt = createdAt;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}	
	
}

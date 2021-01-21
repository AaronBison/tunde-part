package com.Sapi3DTourMongo.Sapi3DTourMongo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Department {
	
	@Id
	private ObjectId _id;

	private String departmentName;

	private String emailAddress;
	
	private String phoneNumber;
	
	private String description;
	
	public Department(String departmentName, String emailAddress, String phoneNumber, String description)
	{
		this.departmentName = departmentName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DepartmentAddRequest {
	
	@NotNull
    @NotEmpty
	private String departmentName;

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
	private String description;

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

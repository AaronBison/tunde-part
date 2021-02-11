package com.Sapi3DTourMongo.Sapi3DTourMongo.models;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Branch {

	@Id
	private ObjectId _id;
	
	private String branchName;
	
	private String coordinatorName;
	
	private String coordinatorEmail;
	
	private String roomNumber;
	
	private String link;
	
	private String departmentName;
	
	public Branch (String branchName, String coordinatorName, String coordinatorEmail, String roomNumber, String link, String departmentName)
	{
		this.branchName = branchName;
		this.coordinatorEmail = coordinatorEmail;
		this.coordinatorName = coordinatorName;
		this.roomNumber= roomNumber;
		this.link = link;
		this.departmentName = departmentName;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	public String getCoordinatorEmail() {
		return coordinatorEmail;
	}

	public void setCoordinatorEmail(String coordinatorEmail) {
		this.coordinatorEmail = coordinatorEmail;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}

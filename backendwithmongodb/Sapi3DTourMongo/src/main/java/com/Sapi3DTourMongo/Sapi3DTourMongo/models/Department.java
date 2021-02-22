package com.Sapi3DTourMongo.Sapi3DTourMongo.models;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Department {
	
	@Id
	private ObjectId _id;

	private String departmentName;

	private String link;
	
	private Set<String> branchesId = new HashSet<>();
	
	private Set<String> otherBranchesId = new HashSet<>();
	
	public Department(String departmentName, String link)
	{
		this.departmentName = departmentName;
		this.link = link;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Set<String> getBranchesId() {
		return branchesId;
	}

	public void setBranchesId(String branchId) {
		this.branchesId.add(branchId);
	}

	public Set<String> getOtherBranchesId() {
		return otherBranchesId;
	}

	public void setOtherBranchesId(String otherBranchId) {
		this.otherBranchesId.add(otherBranchId);
	}
	
}

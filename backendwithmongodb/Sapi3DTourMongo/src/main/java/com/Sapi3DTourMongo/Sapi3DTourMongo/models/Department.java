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
	
	private Set<Branch> branches = new HashSet<>();
	
	private Set<OthersBranch> otherBranches = new HashSet<>();
	
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

	public Set<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Branch branch) {
		this.branches.add(branch);
	}

	public Set<OthersBranch> getOtherBranches() {
		return otherBranches;
	}

	public void setOtherBranches(OthersBranch otherBranch) {
		this.otherBranches.add(otherBranch);
	}
	
}

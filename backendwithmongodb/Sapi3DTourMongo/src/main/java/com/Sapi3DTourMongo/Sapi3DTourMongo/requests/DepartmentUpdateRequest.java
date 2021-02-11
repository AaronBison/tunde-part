package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;

public class DepartmentUpdateRequest {
	
	@NotNull
    @NotEmpty
	private String _id;
	
	@NotNull
    @NotEmpty
	private String departmentName;

	@NotNull
    @NotEmpty
	private String link;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
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

}

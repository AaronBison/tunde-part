package com.Sapi3DTourMongo.Sapi3DTourMongo.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DepartmentAddRequest {
	
	@NotNull
    @NotEmpty
	private String departmentName;

	@NotNull
    @NotEmpty
	private String link;

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

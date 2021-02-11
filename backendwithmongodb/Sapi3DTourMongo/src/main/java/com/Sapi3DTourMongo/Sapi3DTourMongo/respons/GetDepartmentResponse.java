package com.Sapi3DTourMongo.Sapi3DTourMongo.respons;

public class GetDepartmentResponse {
	
	private String id;
	
	private String departmentName;

	private String link;
	
	public GetDepartmentResponse(String id, String departmentName, String link)
	{
		this.id = id;
		this.departmentName = departmentName;
		this.link = link;
	}

	public String getid() {
		return id;
	}

	public void set_id(String id) {
		this.id = id;
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

package com.sapi3dtour.sapi3dtour.messages;

public class BranchMsg {

	private Long id;
	
	private Long department_id;
	
	private Long contact_person_id;
	
	private String description;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	public Long getContact_person_id() {
		return contact_person_id;
	}

	public void setContact_person_id(Long contact_person_id) {
		this.contact_person_id = contact_person_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

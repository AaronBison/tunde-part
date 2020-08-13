package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sapi3dtour.sapi3dtour.messages.BranchMsg;

@Entity
@Table(name = "branch")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCH_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "BRANCH_ID_SEQ", name = "BRANCH_ID_SEQ_GEN")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "contact_person_id", nullable = false)
	private ContactPerson contactPerson;
	
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", columnDefinition="TEXT")
	private String description;
	
	public Branch() {
		
	}
	
	public Branch(BranchMsg branchMsg, Department department, ContactPerson contactPerson)
	{
		this.department = department;
		this.contactPerson = contactPerson;
		this.name = branchMsg.getName();
		this.description = branchMsg.getDescription();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

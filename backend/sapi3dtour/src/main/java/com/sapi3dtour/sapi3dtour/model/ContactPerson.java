package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "contact_person")
public class ContactPerson {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_PERSON_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "CONTACT_PERSON_ID_SEQ", name = "CONTACT_PERSON_ID_SEQ_GEN")
	private Long id;
	
	@OneToMany(mappedBy = "contactPerson", cascade = CascadeType.ALL)
	private Set<Branch> branches;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email_address")
	private String email_address;
	
	@Column(name = "phone_number")
	private String phone_number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Set<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}
	
}

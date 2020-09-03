package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "LoginUser")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "USER_ID_SEQ", name = "USER_ID_SEQ_GEN", schema = "PUBLIC", allocationSize = 1)
	private Long id;
	
	@Column(name = "fullName")
	private String fullName;
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name="USER_ROLES", joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"), inverseJoinColumns=@JoinColumn(name="ROLE_ID", referencedColumnName="ID")) 
	private Collection<UserRole> roles = new ArrayList<UserRole>();
	
	@Column(name = "createdAt")
	private Timestamp createdAt;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "emailAddress", unique = true)
	private String emailAddress;
	
	@Column(name = "phoneNumber", unique = true)
	private String phoneNumber;
	
//	public enum Status {
//		Admin,
//		Tanár,
//		Diák
//	}
//	@Enumerated(EnumType.STRING)
//	@Column(name = "Status")
//	private Status status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
//	public Status getStatus() {
//		return status;
//	}
//	public void setStatus(Status status) {
//		this.status = status;
//	}
	public Collection<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<UserRole> roles) {
		this.roles = roles;
	}
	
	
}

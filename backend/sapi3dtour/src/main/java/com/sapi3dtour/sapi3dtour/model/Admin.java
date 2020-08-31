package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Table(name = "Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "ADMIN_ID_SEQ", name = "ADMIN_ID_SEQ_GEN")
	private Long id;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "createdAt")
	private Timestamp createdAt;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "emailAddress")
	private String emailAddress;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	public enum Status {
		Admin,
		Tanár,
		Diák
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	private Status status;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}

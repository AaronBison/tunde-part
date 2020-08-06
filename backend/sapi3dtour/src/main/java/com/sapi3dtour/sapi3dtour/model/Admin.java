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
	
	@Column(name = "full_name")
	private String full_name;
	
	@Column(name = "created_at")
	private Timestamp created_at;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email_address")
	private String email_address;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	public enum Status {
		admin,
		teacher,
		student
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}

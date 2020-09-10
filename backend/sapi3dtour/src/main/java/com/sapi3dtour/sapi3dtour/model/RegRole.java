package com.sapi3dtour.sapi3dtour.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="REGROLES")
public class RegRole {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGROLE_ID_SEQ_GEN")
	@SequenceGenerator(name = "REGROLE_ID_SEQ_GEN", sequenceName = "REGROLE_ID_SEQ", allocationSize = 1)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	
	@Column(name="TOKEN")
	private String token;
	
	@Column(name="VALIDATION_DATE")
	private Timestamp validDate;
	
	@Column(name="IS_ENABLE")
	private boolean enable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getValidDate() {
		return validDate;
	}

	public void setValidDate(Timestamp validDate) {
		this.validDate = validDate;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}

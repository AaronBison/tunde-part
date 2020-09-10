package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;

@Entity(name="ROLES")
public class Role  implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLES_ID_SEQ_GEN")
	@SequenceGenerator(name = "USER_ROLES_ID_SEQ_GEN", sequenceName = "USER_ROLES_ID_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name="ROLE")
	private String authority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}

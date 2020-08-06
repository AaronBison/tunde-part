package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class test {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teszt_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "teszt_ID_SEQ", name = "teszt_ID_SEQ_GEN")
	private Long id;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

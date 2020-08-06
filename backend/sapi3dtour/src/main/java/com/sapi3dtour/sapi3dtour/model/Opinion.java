package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "opinion")
public class Opinion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OPINION_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "OPINION_ID_SEQ", name = "OPINION_ID_SEQ_GEN")
	private Long id;
	
	@Column(name = "description", columnDefinition="TEXT")
	private String description;
	
	@Column(name = "rate")
	private float rate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
	
}

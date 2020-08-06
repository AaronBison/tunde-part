package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "header_img")
public class Header_img {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEADER_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "HEADER_ID_SEQ", name = "HEADER_ID_SEQ_GEN")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "header_img_id", referencedColumnName = "id")
	private Files header_img;
	
	@Column(name = "name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Files getHeader_img() {
		return header_img;
	}

	public void setHeader_img(Files header_img) {
		this.header_img = header_img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

package com.sapi3dtour.sapi3dtour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class Files {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILES_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "FILES_ID_SEQ", name = "FILES_ID_SEQ_GEN")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "extension")
	private String extension;
	
	@Column(name = "file")
	private byte[] file;

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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
}

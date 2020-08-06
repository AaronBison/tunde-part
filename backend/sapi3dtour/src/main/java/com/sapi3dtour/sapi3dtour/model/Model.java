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
import java.sql.Timestamp;

@Entity
@Table(name = "model")
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODEL_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "MODEL_ID_SEQ", name = "MODEL_ID_SEQ_GEN")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "model_3d_id", referencedColumnName = "id")
	private Files model_3d_img;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "created_at")
	private Timestamp created_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Files getModel_3d_img() {
		return model_3d_img;
	}

	public void setModel_3d_img(Files model_3d_img) {
		this.model_3d_img = model_3d_img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}

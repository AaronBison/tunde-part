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
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_ID_SEQ_GEN")
	@SequenceGenerator(sequenceName = "EVENT_ID_SEQ", name = "EVENT_ID_SEQ_GEN")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "event_img_id", referencedColumnName = "id")
	private Files event_img;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", columnDefinition="TEXT")
	private String description;
	
	@Column(name = "created_at")
	private Timestamp created_at;
	
	@Column(name = "date_start")
	private Timestamp date_start;
	
	@Column(name = "date_end")
	private Timestamp date_end;
	
	@Column(name = "price")
	private Float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Files getEvent_img() {
		return event_img;
	}

	public void setEvent_img(Files event_img) {
		this.event_img = event_img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getDate_start() {
		return date_start;
	}

	public void setDate_start(Timestamp date_start) {
		this.date_start = date_start;
	}

	public Timestamp getDate_end() {
		return date_end;
	}

	public void setDate_end(Timestamp date_end) {
		this.date_end = date_end;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
}

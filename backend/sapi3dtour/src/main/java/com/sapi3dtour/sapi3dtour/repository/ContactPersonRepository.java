package com.sapi3dtour.sapi3dtour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapi3dtour.sapi3dtour.model.ContactPerson;


public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {
	
	public List<ContactPerson> findAll();
	
	public ContactPerson findAllById(Long id);

}

package com.sapi3dtour.sapi3dtour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapi3dtour.sapi3dtour.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	public List<Admin> findAll();

}

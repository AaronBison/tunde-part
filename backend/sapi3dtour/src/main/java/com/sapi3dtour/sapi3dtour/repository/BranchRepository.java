package com.sapi3dtour.sapi3dtour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapi3dtour.sapi3dtour.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
	
	public List<Branch> findAll();

}

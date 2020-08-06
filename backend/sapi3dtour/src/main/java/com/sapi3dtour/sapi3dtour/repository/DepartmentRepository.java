package com.sapi3dtour.sapi3dtour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapi3dtour.sapi3dtour.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	public List<Department> findAll();
	
	public Department findAllById(Long id);
	
}

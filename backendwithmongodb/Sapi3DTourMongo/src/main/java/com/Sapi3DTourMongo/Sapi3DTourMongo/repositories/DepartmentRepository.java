package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;

public interface DepartmentRepository extends MongoRepository<Department,String>{
	
	Boolean existsByDepartmentName(String departmentName);
	
	List<Department> findAll();
	
}

package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import java.util.List;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentAddRequest;

public interface DepartmentService {

	public void addDepartment(DepartmentAddRequest depReq) throws Exception;
	
	public List<Department> getDepartments() throws Exception;

	List<String> getDepartmentsByDepartmentName() throws Exception;
}

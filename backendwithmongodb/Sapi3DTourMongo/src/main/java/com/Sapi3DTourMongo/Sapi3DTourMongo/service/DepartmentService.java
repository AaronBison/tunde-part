package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import java.util.List;
import java.util.Set;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Branch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.OthersBranch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentUpdateRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.GetDepartmentResponse;

public interface DepartmentService {

	public void addDepartment(DepartmentAddRequest depReq) throws Exception;
	
	public List<Department> getDepartments() throws Exception;

	List<String> getDepartmentsByDepartmentName() throws Exception;

	GetDepartmentResponse getDepartment(String departmentName) throws Exception;
	
	public Set<Branch> getDepartmentBranchesByDepartmentName(String departmentName) throws Exception;
	
	public Set<OthersBranch> getDepartmentOtherBranchesByDepartmentName(String departmentName) throws Exception;
	
	public void updateDepartment(DepartmentUpdateRequest depReq) throws Exception;
}

package com.Sapi3DTourMongo.Sapi3DTourMongo.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Branch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.OthersBranch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentUpdateRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.GetByDepartmentNameRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.GetDepartmentResponse;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/addDepartment")
	public ResponseEntity<?> addDepartment(@Valid @RequestBody DepartmentAddRequest depReq) throws Exception
	{
		departmentService.addDepartment(depReq);
		return ResponseEntity.ok("Department add successfully");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getDepartments") 
	public ResponseEntity<?> getDepartments() throws Exception
	{
		List<Department> dep = departmentService.getDepartments();
		return ResponseEntity.ok(dep);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getDepartmentsByDepartmentName")
	public ResponseEntity<?> getDepartmentsByDepartmentName() throws Exception
	{
		List<String> listDepName = departmentService.getDepartmentsByDepartmentName();
		return ResponseEntity.ok(listDepName);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/getDepartment") 
	public ResponseEntity<?> getDepartment(@Valid @RequestBody GetByDepartmentNameRequest depReq) throws Exception
	{
		GetDepartmentResponse dep = departmentService.getDepartment(depReq.getDepartmentName());
		return ResponseEntity.ok(dep);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/getDepartmentBranchesByDepartmentName") 
	public ResponseEntity<?> getDepartmentBranchesByDepartmentName(@Valid @RequestBody GetByDepartmentNameRequest depReq) throws Exception
	{
		Set<Branch> dep = departmentService.getDepartmentBranchesByDepartmentName(depReq.getDepartmentName());
		return ResponseEntity.ok(dep);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/getDepartmentOtherBranchesByDepartmentName") 
	public ResponseEntity<?> getDepartmentOtherBranchesByDepartmentName(@Valid @RequestBody GetByDepartmentNameRequest depReq) throws Exception
	{
		Set<OthersBranch> dep = departmentService.getDepartmentOtherBranchesByDepartmentName(depReq.getDepartmentName());
		return ResponseEntity.ok(dep);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/updateDepartment") 
	public ResponseEntity<?> updateDepartment(@Valid @RequestBody DepartmentUpdateRequest depReq) throws Exception
	{
		departmentService.updateDepartment(depReq);
		return ResponseEntity.ok("Department update is succesfully!");
	}
	
}

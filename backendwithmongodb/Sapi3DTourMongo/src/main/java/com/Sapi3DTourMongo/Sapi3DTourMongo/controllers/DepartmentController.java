package com.Sapi3DTourMongo.Sapi3DTourMongo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentAddRequest;
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

}

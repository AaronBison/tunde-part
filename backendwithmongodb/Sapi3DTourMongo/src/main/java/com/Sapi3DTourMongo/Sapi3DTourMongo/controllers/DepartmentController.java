package com.Sapi3DTourMongo.Sapi3DTourMongo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/addDepartment")
	public ResponseEntity<?> addDepartment(@Valid @RequestBody DepartmentAddRequest depReq)
	{
		if(departmentService.addDepartment(depReq))
		{
			return ResponseEntity.ok("Department add successfully");
		}
		return ResponseEntity.ok(false);
	}

}

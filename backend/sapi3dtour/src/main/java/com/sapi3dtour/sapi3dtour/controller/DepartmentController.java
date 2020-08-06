package com.sapi3dtour.sapi3dtour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.model.Department;
import com.sapi3dtour.sapi3dtour.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentService depService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addNewDepartment", consumes = "application/json", produces = "application/json")
	public void add_new_department(@RequestBody Department department) {
		depService.addNewDepartment(department);
	}
}

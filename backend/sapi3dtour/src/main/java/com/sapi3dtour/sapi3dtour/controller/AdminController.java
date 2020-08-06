package com.sapi3dtour.sapi3dtour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.model.Admin;
import com.sapi3dtour.sapi3dtour.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addNewAdmin", consumes = "application/json", produces = "application/json")
	public void addNewBranch(@RequestBody Admin admin) {
		
		adminService.addNewAdmin(admin);
		
	}

}

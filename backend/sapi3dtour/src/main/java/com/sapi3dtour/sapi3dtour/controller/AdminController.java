package com.sapi3dtour.sapi3dtour.controller;

import javax.validation.Valid;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.messages.LoginMsg;
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
	
	@RequestMapping(method = RequestMethod.GET, path = "/returnAdmin")
	public Admin returnAdminBy(@RequestParam Long id){
		return adminService.returnAdminBy(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateAdminData")
	public void updateAdminData(@RequestBody Admin admin){
		adminService.updateAdminData(admin);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/loginUser")
	public Admin loginUser(@Valid @RequestBody LoginMsg user) {
		return adminService.loginUser(user);
	}
}

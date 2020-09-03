package com.sapi3dtour.sapi3dtour.controller;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.model.User;
import com.sapi3dtour.sapi3dtour.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService adminService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addNewAdmin", consumes = "application/json", produces = "application/json")
	public void addNewBranch(@RequestBody User user) {
		adminService.addNewAdmin(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/returnAdmin")
	public User returnAdminBy(@RequestParam Long id){
		return adminService.returnAdminBy(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateAdminData")
	public void updateAdminData(@RequestBody User user){
		adminService.updateAdminData(user);
	}
	
}

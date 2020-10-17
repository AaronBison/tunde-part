package com.sapi3dtour.sapi3dtour.controller;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.model.User;
import com.sapi3dtour.sapi3dtour.service.UserService;
import com.sapi3dtour.sapi3dtour.service.impl.UserServiceImplementation;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService adminService;
	
	@Autowired
	UserServiceImplementation userService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/returnAdmin")
	public User returnAdminById(@RequestParam Long id){
		return adminService.returnAdminById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateAdminData")
	public void updateAdminData(@RequestBody User user){
		adminService.updateAdminData(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/returnUserList")
	public List<String> returnUserList(){
		return adminService.returnUsers();
	}
	@RequestMapping(method = RequestMethod.GET, path = "/returnUserEmail")
	public User returnUserEmail(@RequestParam String emailAddress) {
		return adminService.getUser(emailAddress);
	}
	@RequestMapping(method = RequestMethod.PUT, path = "/deleteUser")
	public ResponseEntity<Object> deleteUser(@RequestParam String emailAddress) throws Exception {
		userService.deleteUser(emailAddress);
		return ResponseEntity.ok("Delete successed!");
	}
}

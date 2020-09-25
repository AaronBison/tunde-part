package com.sapi3dtour.sapi3dtour.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.messages.PasswordReqMsg;
import com.sapi3dtour.sapi3dtour.service.PasswordService;

@RestController
@RequestMapping("/user")
public class PasswordController {
	
	@Autowired
	private PasswordService passwordService;
	
	@PostMapping
	@RequestMapping("/password")
	public ResponseEntity<?> passwordAdd(@Valid @RequestBody PasswordReqMsg passwordRequestion) throws Exception {
		passwordService.addPassword(passwordRequestion);
		return ResponseEntity.ok("Save successed");
	}
}

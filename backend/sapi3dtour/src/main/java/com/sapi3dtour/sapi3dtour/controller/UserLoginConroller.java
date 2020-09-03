package com.sapi3dtour.sapi3dtour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.config.JwtTokenUtil;

import com.sapi3dtour.sapi3dtour.service.UserService;

import com.sapi3dtour.sapi3dtour.service.impl.LoginUserDetailsService;

import com.sapi3dtour.sapi3dtour.messages.LoginReqMsg;
import com.sapi3dtour.sapi3dtour.messages.LoginResMsg;
import com.sapi3dtour.sapi3dtour.model.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserLoginConroller {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginReqMsg authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getEmailAddress(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getEmailAddress());

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		User user = userService.getUser(userDetails.getUsername());
		
		Long id = user.getId();
		
		return ResponseEntity.ok(new LoginResMsg(token,id));
	}
	
	@PostMapping
	@RequestMapping("/registration")
	public ResponseEntity<Object> registrateUser(@RequestBody User user) {
		userService.saveUser(user);
		return ResponseEntity.ok("Save successed");
	}
	
	private void authenticate(String emailAddress, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(emailAddress, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}

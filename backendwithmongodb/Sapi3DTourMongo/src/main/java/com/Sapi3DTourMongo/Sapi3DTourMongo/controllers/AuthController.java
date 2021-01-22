package com.Sapi3DTourMongo.Sapi3DTourMongo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sapi3DTourMongo.Sapi3DTourMongo.config.JwtUtils;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.LoginRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.PasswordRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.RegistrationRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.LoginResponse;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.MessageResponse;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.LoginUserService;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl.UserDetailsImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	LoginUserService loginUserService;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new LoginResponse(jwt, 
												userDetails.getId(), 
												 roles));
	}

	@PostMapping("/registration")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) throws Exception
	{
		loginUserService.registerNewUser(registrationRequest);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		
	}
	
	@PostMapping("/password")
	public ResponseEntity<?> passwordAdd(@Valid @RequestBody PasswordRequest passwordRequest) throws Exception {
		loginUserService.passwordSave(passwordRequest);
		return ResponseEntity.ok(new MessageResponse("Password add successfully!"));
	}

}

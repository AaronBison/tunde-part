package com.Sapi3DTourMongo.Sapi3DTourMongo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.User;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.UserDataUpdateRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.UserDataWithEmailAddressRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.UserDataWithIdRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.UserDataWithEmailAddressResponse;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.UserDataWithIdResponse;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, path = "/getUserById")
	public ResponseEntity<?> getUserById(@Valid @RequestBody UserDataWithIdRequest id) throws Exception
	{
		Optional<User> us = userService.getUserById(id.getId());
		return ResponseEntity.ok(
				new UserDataWithIdResponse(
						us.get().getUsername(),
						us.get().getCreatedAt(),
						us.get().getEmailAddress(),
						us.get().getPassword(),
						us.get().getPhoneNumber()
					));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getUsersByEmailAddress")
	public ResponseEntity<?> getUsersByEmailAddress() throws Exception
	{
		List<String> listEmail = userService.getUsersByEmailAddress();
		return ResponseEntity.ok(listEmail);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/getUserByEmailAddress")
	public ResponseEntity<?> getUserByEmailAddress(@Valid @RequestBody UserDataWithEmailAddressRequest emailAddressRequest) throws Exception
	{
		Optional<User> user = userService.getUserByEmailAddress(emailAddressRequest.getEmailAddress());
		return ResponseEntity.ok(
				new UserDataWithEmailAddressResponse(
						user.get().getId().toHexString(),
						user.get().getUsername(),
						user.get().getEmailAddress(),
						user.get().getPhoneNumber()
				));
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/deleteUserByEmailAddress")
	public ResponseEntity<?> deleteUserByEmailAddress(@Valid @RequestBody UserDataWithEmailAddressRequest emailAddressRequest) throws Exception
	{
		userService.deleteUserByEmailAddress(emailAddressRequest.getEmailAddress());
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/updateUserById")
	public ResponseEntity<?> updateUserById(@RequestBody UserDataUpdateRequest user) throws Exception
	{
		userService.updateUserById(user);
		return ResponseEntity.ok(true);
	}
	
}

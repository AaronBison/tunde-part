package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.User;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.UserDataUpdateRequest;

public interface UserService {
	
	public Optional<User> getUserById(ObjectId id);
	
	public List<String> getUsersByEmailAddress();

	public Optional<User> getUserByEmailAddress(String emailAddress);
	
	public Boolean deleteUserByEmailAddress(String emailAddress);
	
	public Boolean updateUserById(UserDataUpdateRequest user);
}

package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.User;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.UserDataUpdateRequest;

public interface UserService {
	
	public Optional<User> getUserById(ObjectId id) throws Exception;
	
	public List<String> getUsersByEmailAddress() throws Exception;

	public Optional<User> getUserByEmailAddress(String emailAddress) throws Exception;
	
	public void deleteUserByEmailAddress(String emailAddress) throws Exception;
	
	public void updateUserById(UserDataUpdateRequest user) throws Exception;
}

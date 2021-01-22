package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.User;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.UserRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.UserDataUpdateRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public Optional<User> getUserById(ObjectId id) throws Exception
	{
		try {
			Optional<User> us = userRepository.findBy_id(id);
			return us;
		} catch (Exception e) {
			throw new Exception("Wrong user id!");
		}
		
	}

	@Override
	public List<String> getUsersByEmailAddress() throws Exception
	{
		try {
			List<User> usList = userRepository.findAll();
			List<String> emailStringList = new ArrayList<>(); ;
			usList.stream().forEach((c) -> emailStringList.add(c.getEmailAddress()));
			return emailStringList;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Not users!");
		}
	}

	@Override
	public Optional<User> getUserByEmailAddress(String emailAddress) throws Exception
	{
		try {
			return userRepository.findByEmailAddress(emailAddress);
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Wrong user email get!");
		}
	}

	@Override
	public void deleteUserByEmailAddress(String emailAddress) throws Exception
	{
		try
		{
			userRepository.deleteByEmailAddress(emailAddress);
		}catch (Exception e) {
			System.out.println(e);
			throw new Exception("Wrong user email delete!");
		}
	}

	@Override
	public void updateUserById(UserDataUpdateRequest user) throws Exception
	{
		try {
			Optional<User> oldUser = userRepository.findBy_id(user.get_id());
			oldUser.get().setUsername(user.getUsername());
			oldUser.get().setEmailAddress(user.getEmailAddress());
			oldUser.get().setPhoneNumber(user.getPhoneNumber());
			userRepository.save(oldUser.get());
		}catch (Exception e) {
			System.out.println(e);
			throw new Exception("Faild user update!");
		}
	}
	
	
	
}

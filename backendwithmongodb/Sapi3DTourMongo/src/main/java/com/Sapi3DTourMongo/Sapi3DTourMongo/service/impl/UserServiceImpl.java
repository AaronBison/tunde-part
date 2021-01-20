package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.User;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.UserRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public Optional<User> getUserById(ObjectId id) {
		Optional<User> us = userRepository.findBy_id(id);
		return us;
	}

	@Override
	public List<String> getUsersByEmailAddress() {
		try {
			List<User> usList = userRepository.findAll();
			List<String> emailStringList = new ArrayList<>(); ;
			usList.stream().forEach((c) -> emailStringList.add(c.getEmailAddress()));
			return emailStringList;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Optional<User> getUserByEmailAddress(String emailAddress) {
		try {
			return userRepository.findByEmailAddress(emailAddress);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Boolean deleteUserByEmailAddress(String emailAddress) {
		try
		{
			userRepository.deleteByEmailAddress(emailAddress);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	
}

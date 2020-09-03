package com.sapi3dtour.sapi3dtour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.model.User;
import com.sapi3dtour.sapi3dtour.repository.UserRepository;
import com.sapi3dtour.sapi3dtour.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void addNewAdmin(User admin) {
		
		userRepo.save(admin);
	}

	@Override
	public User returnAdminBy(Long id) {
		
		return userRepo.findAllById(id);
	}

	@Override
	public void updateAdminData(User user) {
		
		User oldAdmin = userRepo.findAllById(user.getId());
		oldAdmin.setFullName(user.getFullName());
		oldAdmin.setEmailAddress(user.getEmailAddress());
		oldAdmin.setPhoneNumber(user.getPhoneNumber());
		userRepo.save(oldAdmin);
	}
	
	@Override
	public void saveUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		
	}

	@Override
	public User getUser(String username) {
		
		return userRepo.findAllByEmailAddress(username);
	}
}

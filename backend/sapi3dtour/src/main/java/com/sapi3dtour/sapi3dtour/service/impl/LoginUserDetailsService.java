package com.sapi3dtour.sapi3dtour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.model.User;
import com.sapi3dtour.sapi3dtour.repository.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findAllByEmailAddress(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		} 
		return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(), user.getRoles());
	}
	
}

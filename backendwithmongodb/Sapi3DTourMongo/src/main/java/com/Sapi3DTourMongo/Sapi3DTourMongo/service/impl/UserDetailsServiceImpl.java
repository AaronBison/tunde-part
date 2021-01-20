package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.User;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
		User user = userRepository.findByEmailAddress(emailAddress)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with emailaddress: " + emailAddress));
		return UserDetailsImpl.build(user);
	}

}
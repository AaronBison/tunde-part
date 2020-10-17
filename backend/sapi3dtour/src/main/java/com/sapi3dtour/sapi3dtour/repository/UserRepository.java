package com.sapi3dtour.sapi3dtour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapi3dtour.sapi3dtour.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findAll();
	
	public User findAllById(Long id);
	
	public User findAllByEmailAddress(String emailAddress);
	
	public User findAllByPhoneNumber(String phoneNumber);
	
	public void deleteByEmailAddress(String emailAddress);
}

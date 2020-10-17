package com.sapi3dtour.sapi3dtour.service;

import java.util.List;

import com.sapi3dtour.sapi3dtour.model.User;

public interface UserService {
	
	public User returnAdminById(Long id);
	
	public void updateAdminData(User user);
	
	public User getUser(String username);
	
	public void saveUser(User user);
	
	public List<String> returnUsers();
	
}

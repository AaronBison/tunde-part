package com.sapi3dtour.sapi3dtour.service;

import com.sapi3dtour.sapi3dtour.model.User;

public interface UserService {
	
	public void addNewAdmin(User user);
	
	public User returnAdminBy(Long id);
	
	public void updateAdminData(User user);
	
	public User getUser(String username);
	
	public void saveUser(User user);
}

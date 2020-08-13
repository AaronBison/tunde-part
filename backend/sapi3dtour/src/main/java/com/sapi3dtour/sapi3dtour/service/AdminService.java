package com.sapi3dtour.sapi3dtour.service;

import com.sapi3dtour.sapi3dtour.model.Admin;

public interface AdminService {
	
	public void addNewAdmin(Admin admin);
	
	public Admin returnAdminBy(Long id);
	
	public void updateAdminData(Admin admin);

}

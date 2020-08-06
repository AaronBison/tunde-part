package com.sapi3dtour.sapi3dtour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.model.Admin;
import com.sapi3dtour.sapi3dtour.repository.AdminRepository;
import com.sapi3dtour.sapi3dtour.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService {
	
	@Autowired
	AdminRepository adminRepo;

	@Override
	public void addNewAdmin(Admin admin) {
		
		adminRepo.save(admin);
		
	}

}

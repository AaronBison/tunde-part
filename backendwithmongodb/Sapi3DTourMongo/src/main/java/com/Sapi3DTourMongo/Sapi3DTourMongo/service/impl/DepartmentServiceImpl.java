package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.DepartmentRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public boolean addDepartment(DepartmentAddRequest depReq) {
		if(departmentRepository.existsByDepartmentName(depReq.getDepartmentName()))
		{
			return false;
		}
		try {
			Department dep = new Department(depReq.getDepartmentName(), depReq.getEmailAddress(), depReq.getPhoneNumber(), depReq.getDescription());
			departmentRepository.save(dep);
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}

package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public void addDepartment(DepartmentAddRequest depReq) throws Exception {
		if(departmentRepository.existsByDepartmentName(depReq.getDepartmentName()))
		{
			throw new Exception("Department already exist!");
		}
		try {
			Department dep = new Department(depReq.getDepartmentName(), depReq.getLink());
			departmentRepository.save(dep);
			
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Wrong add department!");
		}
	}

	@Override
	public List<Department> getDepartments() throws Exception{
		try {
			List<Department> dep = departmentRepository.findAll();
			return dep;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("No departments!");
		}
	}

	@Override
	public List<String> getDepartmentsByDepartmentName() throws Exception
	{
		try {
			List<Department> depList = departmentRepository.findAll();
			List<String> nameStringList = new ArrayList<>(); ;
			depList.stream().forEach((c) -> nameStringList.add(c.getDepartmentName()));
			return nameStringList;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Not departments!");
		}
	}
	
}

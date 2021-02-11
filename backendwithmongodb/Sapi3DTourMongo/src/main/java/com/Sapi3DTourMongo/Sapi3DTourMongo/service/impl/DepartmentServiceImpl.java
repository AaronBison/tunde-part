package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Branch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.OthersBranch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.DepartmentRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.DepartmentUpdateRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.GetDepartmentResponse;
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
			List<Department> dep = departmentRepository.findByOrderByDepartmentNameAsc();
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
			List<Department> depList = departmentRepository.findByOrderByDepartmentNameAsc();
			List<String> nameStringList = new ArrayList<>(); ;
			depList.stream().forEach((c) -> nameStringList.add(c.getDepartmentName()));
			return nameStringList;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Not departments!");
		}
	}
	
	@Override
	public GetDepartmentResponse getDepartment(String departmentName) throws Exception{
		if(!departmentRepository.existsByDepartmentName(departmentName))
		{
			throw new Exception("Department not exist!");
		}
		try {
			Department dep = departmentRepository.findByDepartmentName(departmentName);
			GetDepartmentResponse resp = new GetDepartmentResponse(dep.get_id().toString(), dep.getDepartmentName(), dep.getLink());
			return resp;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("No departments!");
		}
	}
	@Override
	public Set<Branch> getDepartmentBranchesByDepartmentName(String departmentName) throws Exception {
		if(!departmentRepository.existsByDepartmentName(departmentName))
		{
			throw new Exception("Department not exist!");
		}
		try {
			Set<Branch> resp = departmentRepository.findByDepartmentName(departmentName).getBranches();
			return resp;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("No departments!");
		}
	}
	
	@Override
	public Set<OthersBranch> getDepartmentOtherBranchesByDepartmentName(String departmentName) throws Exception {
		if(!departmentRepository.existsByDepartmentName(departmentName))
		{
			throw new Exception("Department not exist!");
		}
		try {
			Set<OthersBranch> resp = departmentRepository.findByDepartmentName(departmentName).getOtherBranches();
			return resp;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("No departments!");
		}
	}

	@Override
	public void updateDepartment(DepartmentUpdateRequest depReq) throws Exception {
		try {
			Department dep = departmentRepository.findBy_id(depReq.get_id());
			dep.setDepartmentName(depReq.getDepartmentName());
			dep.setLink(depReq.getLink());
			departmentRepository.save(dep);
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("The update is faild!");
		}
		
	}
	
}

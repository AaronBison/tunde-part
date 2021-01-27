package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Branch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.BranchRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.DepartmentRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public void addBranch(BranchAddRequest branReq) throws Exception {
		if(branchRepository.existsByBranchName(branReq.getBranchName()))
		{
			throw new Exception("Branch already exist!");
		}
		try {
			Branch branch = new Branch(branReq.getBranchName(), branReq.getCoordinatorName(), branReq.getCoordinatorEmail(), branReq.getRoomNumber(), branReq.getLink());
			Department dep = departmentRepository.findByDepartmentName(branReq.getDepartmentName());
			branch.setDepartment(dep);
			branchRepository.save(branch);
			
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Wrong add branch!");
		}
	}
}
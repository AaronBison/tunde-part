package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Branch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.BranchRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.DepartmentRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchUpdateRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.GetBranchNameResponse;
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
			Branch branch = new Branch(branReq.getBranchName(), branReq.getCoordinatorName(), branReq.getCoordinatorEmail(), branReq.getRoomNumber(), 
										branReq.getLink(),branReq.getDepartmentName());
			branchRepository.save(branch);
			branch = branchRepository.findByBranchName(branReq.getBranchName());
			Department dep = departmentRepository.findByDepartmentName(branReq.getDepartmentName());
			dep.setBranchesId(branch.get_id().toString());
			departmentRepository.save(dep);
			
			
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Wrong add branch!");
		}
	}

	@Override
	public Set<String> getBranchesName() throws Exception {
		try {
			List<Branch> brList = branchRepository.findAll();
			Set<String> nameList = new HashSet<>();
			for (Branch branch : brList) {
				nameList.add(branch.getBranchName());
			}
			return nameList;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("No branches!");
		}
	}

	@Override
	public GetBranchNameResponse getBranchByName(String name) throws Exception {
		if(!branchRepository.existsByBranchName(name))
		{
			throw new Exception("Branch not exist!");
		}
		try {
			Branch bran = branchRepository.findByBranchName(name);
			GetBranchNameResponse resp = new GetBranchNameResponse(bran.get_id().toString(), bran.getBranchName(),bran.getCoordinatorName(),
														bran.getCoordinatorEmail(), bran.getRoomNumber(), bran.getLink());
			return resp;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Branch not exist!");
		}
	}

	@Override
	public void updateBranch(BranchUpdateRequest branReq) throws Exception {
		try {
			Branch bran = branchRepository.findBy_id(branReq.getId());
			bran.setBranchName(branReq.getBranchName());
			bran.setCoordinatorEmail(branReq.getCoordinatorEmail());
			bran.setCoordinatorName(branReq.getCoordinatorName());
			bran.setRoomNumber(branReq.getRoomNumber());
			bran.setLink(branReq.getLink());
			branchRepository.save(bran);
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Branch update faild!");
		}
		
	}
}

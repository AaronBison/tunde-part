package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.OthersBranch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.DepartmentRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.OthersBranchRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.OthersBranchAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.OthersBranchService;

@Service
public class OthersBranchServiceImpl implements OthersBranchService {

	@Autowired
	OthersBranchRepository othersBranchRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public void addOthersBranch(OthersBranchAddRequest othBranreq) throws Exception {
		try {
			OthersBranch othBranch = new OthersBranch(othBranreq.getValue1(),othBranreq.getValue2(), othBranreq.getValue3(), 
													othBranreq.getValue4(), othBranreq.getValue5(),othBranreq.getDepartmentName());
			othersBranchRepository.save(othBranch);
			othBranch = othersBranchRepository.findByValue1AndValue2AndValue3AndValue4AndValue5(othBranreq.getValue1(),
																								othBranreq.getValue2(), othBranreq.getValue3(), 
					othBranreq.getValue4(), othBranreq.getValue5());
			Department dep = departmentRepository.findByDepartmentName(othBranreq.getDepartmentName());
			dep.setOtherBranchesId(othBranch.get_id().toString());
			departmentRepository.save(dep);
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Wrong add others branch!");
		}
		
	}

}

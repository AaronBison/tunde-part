package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchAddRequest;

import java.util.List;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Branch;

public interface BranchService {
	
	public void addBranch(BranchAddRequest branReq) throws Exception;
	
	public List<Branch> getBranchByDepartment(String department) throws Exception;
	
}

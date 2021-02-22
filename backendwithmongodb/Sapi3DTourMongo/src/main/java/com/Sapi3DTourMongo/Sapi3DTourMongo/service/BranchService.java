package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import java.util.Set;

import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchUpdateRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.respons.GetBranchNameResponse;

public interface BranchService {
	
	public void addBranch(BranchAddRequest branReq) throws Exception;
	
	public Set<String> getBranchesName() throws Exception;
	
	public GetBranchNameResponse getBranchByName(String name) throws Exception;
	
	public void updateBranch(BranchUpdateRequest branReq) throws Exception;
	
}

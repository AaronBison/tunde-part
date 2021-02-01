package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import java.util.List;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.OthersBranch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.OthersBranchAddRequest;

public interface OthersBranchService {

	public void addOthersBranch(OthersBranchAddRequest othBranreq) throws Exception;
	
	public List<OthersBranch> getOthersBranchByDepartment(String department) throws Exception;
}

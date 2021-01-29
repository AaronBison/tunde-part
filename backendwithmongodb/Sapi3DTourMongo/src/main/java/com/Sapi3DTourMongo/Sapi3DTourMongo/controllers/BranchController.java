package com.Sapi3DTourMongo.Sapi3DTourMongo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchGetByDepartmentRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.BranchService;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addBranch")
	public ResponseEntity<?> addDepartment(@Valid @RequestBody BranchAddRequest branReq) throws Exception
	{
		branchService.addBranch(branReq);
		return ResponseEntity.ok("Branch add successfully");
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/getBranchByDepartment")
	public ResponseEntity<?> getBranchByDepartment(@Valid @RequestBody BranchGetByDepartmentRequest branReq) throws Exception
	{
		return ResponseEntity.ok(branchService.getBranchByDepartment(branReq.getDepartmentName()));
	}
}

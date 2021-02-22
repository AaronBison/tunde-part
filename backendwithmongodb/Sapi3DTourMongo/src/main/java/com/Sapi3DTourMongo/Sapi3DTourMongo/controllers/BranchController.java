package com.Sapi3DTourMongo.Sapi3DTourMongo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.BranchUpdateRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.GetByBranchNameRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.BranchService;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addBranch")
	public ResponseEntity<?> addBranch(@Valid @RequestBody BranchAddRequest branReq) throws Exception
	{
		branchService.addBranch(branReq);
		return ResponseEntity.ok("Branch add successfully");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getBranchesName")
	public ResponseEntity<?> getBranchesName() throws Exception
	{
		return ResponseEntity.ok(branchService.getBranchesName());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/getBaranchByName")
	public ResponseEntity<?> getBranchByName(@Valid @RequestBody GetByBranchNameRequest branReq) throws Exception
	{
		return ResponseEntity.ok(branchService.getBranchByName(branReq.getBranchName()));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/updateBranch")
	public ResponseEntity<?> updateBranch(@Valid @RequestBody BranchUpdateRequest branReq) throws Exception
	{
		branchService.updateBranch(branReq);
		return ResponseEntity.ok("Branch update sucessfull!");
	}
}

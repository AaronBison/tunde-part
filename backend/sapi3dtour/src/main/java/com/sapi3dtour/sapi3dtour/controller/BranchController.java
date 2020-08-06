package com.sapi3dtour.sapi3dtour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.messages.BranchMsg;
import com.sapi3dtour.sapi3dtour.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addNewBranch", consumes = "application/json", produces = "application/json")
	public void addNewBranch(@RequestBody BranchMsg branchMsg) {
		
		branchService.addNewBranch(branchMsg);
		
	}
}

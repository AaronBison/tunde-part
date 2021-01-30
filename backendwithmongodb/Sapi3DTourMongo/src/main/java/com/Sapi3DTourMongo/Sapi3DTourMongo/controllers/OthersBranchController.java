package com.Sapi3DTourMongo.Sapi3DTourMongo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.OthersBranchAddRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.OthersBranchService;

@RestController
@RequestMapping("/api/othersBranch")
public class OthersBranchController {
	
	@Autowired
	OthersBranchService otherBranchservice;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addOthersBranch")
	public ResponseEntity<?> addBranch( @Valid @RequestBody OthersBranchAddRequest othBranreq) throws Exception
	{
		otherBranchservice.addOthersBranch(othBranreq);
		return ResponseEntity.ok("Others branch add successfully");
	}
}

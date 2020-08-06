package com.sapi3dtour.sapi3dtour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapi3dtour.sapi3dtour.model.ContactPerson;
import com.sapi3dtour.sapi3dtour.service.ContactPersonService;

@RestController
@RequestMapping("/contact")
public class ContactPersonController {
	@Autowired
	ContactPersonService Cont_persService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/addNewContact", consumes = "application/json", produces = "application/json")
	public void add_new_contact(@RequestBody ContactPerson person) {
		Cont_persService.addNewContact(person);
	}
}

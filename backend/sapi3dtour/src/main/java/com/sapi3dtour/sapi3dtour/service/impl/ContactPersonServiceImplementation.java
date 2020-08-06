package com.sapi3dtour.sapi3dtour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.model.ContactPerson;
import com.sapi3dtour.sapi3dtour.repository.ContactPersonRepository;
import com.sapi3dtour.sapi3dtour.service.ContactPersonService;




@Service
public class ContactPersonServiceImplementation implements ContactPersonService {
	@Autowired
    ContactPersonRepository cont_persRepo;
	
	public void addNewContact(ContactPerson person) {
        try {
            cont_persRepo.save(person);
        } catch (Exception e) {
            System.out.println("Nem adta hozzá  az adatot");
        }
    }
	
}

package com.sapi3dtour.sapi3dtour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.messages.BranchMsg;
import com.sapi3dtour.sapi3dtour.model.Branch;
import com.sapi3dtour.sapi3dtour.model.ContactPerson;
import com.sapi3dtour.sapi3dtour.model.Department;
import com.sapi3dtour.sapi3dtour.repository.BranchRepository;
import com.sapi3dtour.sapi3dtour.repository.ContactPersonRepository;
import com.sapi3dtour.sapi3dtour.repository.DepartmentRepository;
import com.sapi3dtour.sapi3dtour.service.BranchService;

@Service
public class BranchServiceImplementation implements BranchService {
	
	@Autowired
	BranchRepository branchRepo;
	
	@Autowired 
	ContactPersonRepository contactPersonRepo;
	
	@Autowired
	DepartmentRepository departmentRepo;

	@Override
	public void addNewBranch(BranchMsg branchMsg) {
		
		try {
			ContactPerson contactPerson = contactPersonRepo.findAllById(branchMsg.getContact_person_id());
			Department department = departmentRepo.findAllById(branchMsg.getDepartment_id());
			Branch branch = new Branch(branchMsg, department, contactPerson);
			branchRepo.save(branch);
        } catch (Exception e) {
            System.out.println("Nem adta hozzá  az adatot");
        }
		
	}

}

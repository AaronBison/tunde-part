package com.sapi3dtour.sapi3dtour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.model.Department;
import com.sapi3dtour.sapi3dtour.repository.DepartmentRepository;
import com.sapi3dtour.sapi3dtour.service.DepartmentService;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

	@Autowired
	DepartmentRepository depRepo;
	
	@Override
	public void addNewDepartment(Department department) {
		try {
            depRepo.save(department);
        } catch (Exception e) {
            System.out.println("Nem adta hozzá  az adatot");
        }
	}

}

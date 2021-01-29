package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Branch;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;

public interface BranchRepository extends MongoRepository<Branch,ObjectId> {
	
	Boolean existsByBranchName(String branchName);
	
	List<Branch> findByDepartmentOrderByBranchNameAsc(Department department);
	
}

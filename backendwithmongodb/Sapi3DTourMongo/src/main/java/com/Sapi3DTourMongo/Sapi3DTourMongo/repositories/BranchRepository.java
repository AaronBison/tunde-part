package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Branch;

public interface BranchRepository extends MongoRepository<Branch,ObjectId> {
	
	Boolean existsByBranchName(String branchName);
	
	Branch findByBranchName(String branchName);
	
	Branch findBy_id(String _id);
	
//	
//	List<Branch> findByDepartmentOrderByBranchNameAsc(Department department);
	
}

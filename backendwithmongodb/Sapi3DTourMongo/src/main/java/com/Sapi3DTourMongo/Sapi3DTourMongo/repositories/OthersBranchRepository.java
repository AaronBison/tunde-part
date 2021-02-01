package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Department;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.OthersBranch;

public interface OthersBranchRepository extends MongoRepository<OthersBranch, ObjectId> {
	
	List<OthersBranch> findByDepartment(Department department);

}

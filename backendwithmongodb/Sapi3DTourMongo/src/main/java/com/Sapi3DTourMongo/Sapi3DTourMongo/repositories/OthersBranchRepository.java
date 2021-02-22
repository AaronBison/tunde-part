package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.OthersBranch;

public interface OthersBranchRepository extends MongoRepository<OthersBranch, ObjectId> {
	
	OthersBranch findBy_id(String _id);

	OthersBranch findByValue1AndValue2AndValue3AndValue4AndValue5(String value1,String value2,String value3,String value4,String value5);
}

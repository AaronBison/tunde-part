package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.OthersBranch;

public interface OthersBranchRepository extends MongoRepository<OthersBranch, ObjectId> {

}

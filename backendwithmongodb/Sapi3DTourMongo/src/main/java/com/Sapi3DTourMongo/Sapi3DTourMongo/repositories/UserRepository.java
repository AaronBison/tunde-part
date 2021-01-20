package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.User;


public interface UserRepository extends MongoRepository<User, String>  {
	
	Optional<User> findBy_id(ObjectId id);
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmailAddress(String emailAddress);
	
	Boolean existsByUsername(String username);

	Boolean existsByPhoneNumber(String phoneNumber);

	Boolean existsByEmailAddress(String emailAddress);
	
	void deleteByEmailAddress(String emailAddress);
	
}

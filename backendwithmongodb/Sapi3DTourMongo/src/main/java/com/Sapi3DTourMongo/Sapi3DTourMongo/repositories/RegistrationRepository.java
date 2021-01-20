package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Registration;


public interface RegistrationRepository extends MongoRepository<Registration, String> {
	
	Optional<Registration> findByToken(String token);
	
	Boolean existsByToken(String token);
	
}

package com.Sapi3DTourMongo.Sapi3DTourMongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Sapi3DTourMongo.Sapi3DTourMongo.models.ERole;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
	
	Optional<Role> findByName(ERole name);
	
}


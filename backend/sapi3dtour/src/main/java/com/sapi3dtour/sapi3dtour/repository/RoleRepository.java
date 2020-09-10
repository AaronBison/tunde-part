package com.sapi3dtour.sapi3dtour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapi3dtour.sapi3dtour.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByAuthority(String authority);
	
}

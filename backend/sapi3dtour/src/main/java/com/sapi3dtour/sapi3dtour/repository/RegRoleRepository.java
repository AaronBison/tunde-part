package com.sapi3dtour.sapi3dtour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapi3dtour.sapi3dtour.model.RegRole;
import com.sapi3dtour.sapi3dtour.model.User;

public interface RegRoleRepository extends JpaRepository<RegRole, Long> {
	
	RegRole findByToken(String token);
	public void deleteByUser(User user);
}

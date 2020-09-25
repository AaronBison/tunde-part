package com.sapi3dtour.sapi3dtour.service.impl;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.exception.WrongPasswordException;
import com.sapi3dtour.sapi3dtour.messages.PasswordReqMsg;
import com.sapi3dtour.sapi3dtour.model.RegRole;
import com.sapi3dtour.sapi3dtour.model.User;
import com.sapi3dtour.sapi3dtour.repository.RegRoleRepository;
import com.sapi3dtour.sapi3dtour.repository.UserRepository;
import com.sapi3dtour.sapi3dtour.service.PasswordService;

@Service
public class PasswordServiceImplementation implements PasswordService {
	
	@Autowired
	private RegRoleRepository regRoleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Transactional
	public String addPassword(PasswordReqMsg userPassword) throws WrongPasswordException {
		
		if(!regTokenExist(userPassword.getCodeToken()))
		{
			throw new WrongPasswordException("Wrong token!");
		}
		RegRole regRole = regRoleRepo.findByToken(userPassword.getCodeToken());
		if (regRole.isEnable())
		{
			throw new WrongPasswordException("Already exist!");
		}
		Timestamp nowTimestamp = new Timestamp(System.currentTimeMillis());
		if (regRole.getValidDate().before(nowTimestamp)) {
			throw new WrongPasswordException("Time done!");
		}
		User user = userRepo.findAllById(regRole.getUser().getId());
		if (!userPassword.getPassword().equals(userPassword.getPasswordAgain()))
		{
			throw new WrongPasswordException("Wrong password!");
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(userPassword.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		regRole.setEnable(true);
		regRoleRepo.save(regRole);
		return "Password successed";
	}
	
	private boolean regTokenExist(String token) {
		return regRoleRepo.findByToken(token) != null;
	}
}

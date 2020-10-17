package com.sapi3dtour.sapi3dtour.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.exception.EmailNotExistException;
import com.sapi3dtour.sapi3dtour.model.User;
import com.sapi3dtour.sapi3dtour.repository.RegRoleRepository;
import com.sapi3dtour.sapi3dtour.repository.UserRepository;
import com.sapi3dtour.sapi3dtour.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RegRoleRepository regRoleRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}

	@Override
	public User getUser(String username) {
		return userRepo.findAllByEmailAddress(username);
	}

	@Override
	public User returnAdminById(Long id) {
		return userRepo.findAllById(id);
	}

	@Override
	public void updateAdminData(User user) {
		User oldAdmin = userRepo.findAllById(user.getId());
		oldAdmin.setFullName(user.getFullName());
		oldAdmin.setEmailAddress(user.getEmailAddress());
		oldAdmin.setPhoneNumber(user.getPhoneNumber());
		userRepo.save(oldAdmin);
	}

	@Override
	public List<String> returnUsers(){
		List<User> tmp = userRepo.findAll();
		List<String> tmp1 = new ArrayList<>();
		for (int i = 0; i < tmp.size(); i++) {
			tmp1.add(tmp.get(i).getEmailAddress());
		}
		return tmp1;
	}

	@Transactional
	public void deleteUser(String username) throws  EmailNotExistException {
		if(!this.emailExist(username))
		{
			throw new  EmailNotExistException("This email not exist!");
		}
		User user = userRepo.findAllByEmailAddress(username);
		regRoleRepo.deleteByUser(user);
		userRepo.deleteByEmailAddress(username);
	}
	
	private boolean emailExist(String email) {
        return userRepo.findAllByEmailAddress(email) != null;
    }
	
}

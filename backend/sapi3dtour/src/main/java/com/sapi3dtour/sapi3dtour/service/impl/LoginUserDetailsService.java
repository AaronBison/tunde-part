package com.sapi3dtour.sapi3dtour.service.impl;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sapi3dtour.sapi3dtour.exception.UserAlreadyExistException;
import com.sapi3dtour.sapi3dtour.messages.RegReqMsg;
import com.sapi3dtour.sapi3dtour.model.RegRole;
import com.sapi3dtour.sapi3dtour.model.Role;
import com.sapi3dtour.sapi3dtour.model.User;
import com.sapi3dtour.sapi3dtour.repository.RegRoleRepository;
import com.sapi3dtour.sapi3dtour.repository.RoleRepository;
import com.sapi3dtour.sapi3dtour.repository.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	RegRoleRepository regRoleRepo;
	
	@Autowired
    private JavaMailSender emailSender;
	
	private static final SecureRandom secureRandom = new SecureRandom(); 
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findAllByEmailAddress(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		} 
		return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(), user.getRoles());
	}
	
	@Transactional
	public void registerNewUser(RegReqMsg user) throws UserAlreadyExistException {
		if (this.emailExist(user.getEmailAddress()) || this.phoneNumberExist(user.getPhoneNumber()))
		{
			throw new UserAlreadyExistException("This user already exist!");
		}
		
//		Roles tábla feltöltése
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepo.findByAuthority(user.getAuthority()));
		User newUser = new User();
		newUser.setEmailAddress(user.getEmailAddress());
		newUser.setFullName(user.getFullName());
		newUser.setPhoneNumber(user.getPhoneNumber());
		newUser.setRoles(roles);
		userRepo.save(newUser);
		
//		Regroles tábla feltöltése
		newUser = userRepo.findAllByEmailAddress(user.getEmailAddress());
		RegRole regRole = new RegRole();
		regRole.setEnable(false);
		Timestamp oldTimestamp = new Timestamp(System.currentTimeMillis());
		ZonedDateTime zonedDateTime = oldTimestamp.toInstant().atZone(ZoneId.of("UTC"));
		Timestamp newTime = Timestamp.from(zonedDateTime.plus(14, ChronoUnit.DAYS).toInstant());
		regRole.setValidDate(newTime);
		String token = this.generateNewToken();
		regRole.setToken(token);
		regRole.setUser(newUser);
		regRoleRepo.save(regRole);
		
//		Email küldés
        try {
        	MimeMessage mimeMessage = emailSender.createMimeMessage();
    		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
    		String htmlMsg = "Üdvözöljük! Önt sikeresen jelentkeztették az alkalmazás használatára. A jelentkezés véglegesítésére a következő linken adja meg jelszavát! "
    				+ "http://localhost:8080/#/password"
    				+ " Azonosító kódja a következő: "
    				+ token 
            		+ " Figyelem a link elérhetősége korlátozott!";
    		helper.setText(htmlMsg, true);
    		helper.setTo(newUser.getEmailAddress());
    		helper.setSubject("A sapi 3d alkalmazás jelentkeztetése");
    		emailSender.send(mimeMessage);
        }catch (Exception e) {
        	throw new UserAlreadyExistException("Emai send is wrong!");
		}
        
	}
	
	private boolean emailExist(String email) {
        return userRepo.findAllByEmailAddress(email) != null;
    }
	
	private boolean phoneNumberExist(String phoneNumber) {
        return userRepo.findAllByPhoneNumber(phoneNumber) != null;
    }
	
	private String generateNewToken() {
	    byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}
	
}

package com.Sapi3DTourMongo.Sapi3DTourMongo.service.impl;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.exceptions.WrongPasswordException;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.ERole;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Registration;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.Role;
import com.Sapi3DTourMongo.Sapi3DTourMongo.models.User;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.RegistrationRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.RoleRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.repositories.UserRepository;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.PasswordRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.RegistrationRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.service.LoginUserService;

@Service
public class LoginUserServiceImpl implements LoginUserService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RegistrationRepository registartionRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
    private JavaMailSender emailSender;
	
	private static final SecureRandom secureRandom = new SecureRandom(); 
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); 

	@Override
	public boolean registerNewUser(RegistrationRequest registrationRequest) {
		if (userRepository.existsByEmailAddress(registrationRequest.getEmailAddress())) {
			return false;
		}
		try {
			
			Calendar cal = Calendar.getInstance();
			User user = new User(registrationRequest.getUsername(),cal.getTime(), 
					registrationRequest.getEmailAddress(),registrationRequest.getPhoneNumber());

			Set<String> strRoles = registrationRequest.getRoles();
			Set<Role> roles = new HashSet<>();
			if (strRoles == null) {
				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);

						break;
					default:
						Role userRole = roleRepository.findByName(ERole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(userRole);
					}
				});
			}
			user.setRoles(roles);
			userRepository.save(user);
			
//			Registration tábla feltöltése
			User newUser = userRepository.findByEmailAddress(registrationRequest.getEmailAddress()).orElseThrow(() -> new RuntimeException("Error: User is not found."));
			Registration registration = new Registration();
			registration.setEnable(false);
			cal.add(Calendar.DAY_OF_WEEK, 14);
			registration.setValidDate(cal.getTime());			
			String token = this.generateNewToken();
			registration.setToken(token);
			registration.setUser(new HashSet<>(Arrays.asList(newUser)));
			registartionRepository.save(registration);
			
//			Email küldés
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
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	private String generateNewToken() {
	    byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}

	@Override
	public boolean passwordSave(PasswordRequest passwordRequest) throws WrongPasswordException {
		try {
			if(!registartionRepository.existsByToken(passwordRequest.getCodeToken()))
			{
				throw new WrongPasswordException("Wrong token!");
			}
			Registration registartion = registartionRepository.findByToken(passwordRequest.getCodeToken()).orElseThrow(() -> new RuntimeException("Error: Registartion is not found."));
			if (registartion.isEnable())
			{
				throw new WrongPasswordException("Already exist!");
			}
			Calendar cal = Calendar.getInstance();
			if (registartion.getValidDate().before(cal.getTime())) {
				throw new WrongPasswordException("Time done!");
			}
			if (!passwordRequest.getPassword().equals(passwordRequest.getPasswordAgain()))
			{
				throw new WrongPasswordException("Wrong password!");
			}
			Iterator<User> itr = registartion.getUser().iterator();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(passwordRequest.getPassword());
			User user = userRepository.findById(itr.next().getId().toHexString()).orElseThrow(() -> new RuntimeException("Error: User is not found."));
			user.setPassword(encodedPassword);
			userRepository.save(user);
			registartion.setEnable(true);
			registartionRepository.save(registartion);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
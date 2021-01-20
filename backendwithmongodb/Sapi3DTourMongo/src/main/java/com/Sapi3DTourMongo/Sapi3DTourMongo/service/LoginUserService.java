package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.exceptions.WrongPasswordException;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.PasswordRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.RegistrationRequest;

public interface LoginUserService {
	
	boolean registerNewUser(RegistrationRequest registrationRequest);
	
	boolean passwordSave(PasswordRequest passwordRequest) throws WrongPasswordException;
	
}
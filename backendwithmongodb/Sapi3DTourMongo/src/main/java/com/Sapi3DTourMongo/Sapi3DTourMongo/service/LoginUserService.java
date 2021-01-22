package com.Sapi3DTourMongo.Sapi3DTourMongo.service;

import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.PasswordRequest;
import com.Sapi3DTourMongo.Sapi3DTourMongo.requests.RegistrationRequest;

public interface LoginUserService {
	
	void registerNewUser(RegistrationRequest registrationRequest) throws Exception;
	
	void passwordSave(PasswordRequest passwordRequest) throws Exception;
	
}
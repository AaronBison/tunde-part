package com.sapi3dtour.sapi3dtour.service;

import com.sapi3dtour.sapi3dtour.exception.WrongPasswordException;
import com.sapi3dtour.sapi3dtour.messages.PasswordReqMsg;

public interface PasswordService {

	public String addPassword(PasswordReqMsg userPassword) throws WrongPasswordException;
	
}

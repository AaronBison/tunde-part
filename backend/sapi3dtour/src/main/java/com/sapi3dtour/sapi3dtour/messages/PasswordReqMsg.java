package com.sapi3dtour.sapi3dtour.messages;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PasswordReqMsg implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	@NotNull
    @NotEmpty
    @Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{32}$")
	private String codeToken;
	
	@NotNull
    @NotEmpty
    @Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$")
	private String password;
	
	@NotNull
    @NotEmpty
    @Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$")
	private String passwordAgain;
	
	public PasswordReqMsg() {
		
	}
	
	public PasswordReqMsg(String codeToken, String password, String passwordAgain) {
		this.setCodeToken(codeToken);
		this.setPassword(password);
		this.setPasswordAgain(passwordAgain);
	}

	public String getCodeToken() {
		return codeToken;
	}

	public void setCodeToken(String codeToken) {
		this.codeToken = codeToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
}

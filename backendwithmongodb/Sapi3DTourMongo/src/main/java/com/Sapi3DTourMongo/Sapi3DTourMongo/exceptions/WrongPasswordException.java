package com.Sapi3DTourMongo.Sapi3DTourMongo.exceptions;

public class WrongPasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongPasswordException(String string) {
		super(string);
	}

}

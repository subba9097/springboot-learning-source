package com.akshay.organization.exception;

public class DuplicatePhoneNumberException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicatePhoneNumberException(String message) {
		super(message);
	}

}

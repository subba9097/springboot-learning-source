package com.akshay.organization.exception;

public class EmployeeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6910998741962384081L;
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	

}

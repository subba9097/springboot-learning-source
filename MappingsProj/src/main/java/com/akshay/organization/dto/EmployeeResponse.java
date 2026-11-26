package com.akshay.organization.dto;

import com.akshay.organization.entity.Passport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Double phoneNumber;
	
	private Passport passport;

}

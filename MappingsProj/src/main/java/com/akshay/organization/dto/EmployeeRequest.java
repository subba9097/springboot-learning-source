package com.akshay.organization.dto;

import com.akshay.organization.entity.Passport;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

	@NotBlank(message = "name should not be blank")
	private String name;

	@Pattern(regexp = "^[A-Za-z0-9+_.-]+[@]gmail[.]com$", message = "Invalid email address")
	private String email;

	@Positive(message = "salary must be positive")
	private Double salary;

	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid Phone number")
	private String phoneNumber;

	private Passport passport;

}

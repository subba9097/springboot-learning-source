package org.subbumaaya.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

	@NotBlank(message = "person name cannot be null")
	private String name;

	@Pattern(regexp = "^[A-Za-z0-9_+.-]+[@]gmail[.]com$", message = "Invalid Email address")
	private String email;

	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,}$", message = "Invalid Password")
	private String password;

	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid Mobile number")
	private String phoneNumber;

	private PassportRequest passportRequest;

}

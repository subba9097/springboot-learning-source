package org.subbumaaya.dto;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PassportRequest {
	
	@NotBlank(message = "passport number cannot be null")
	private String passportNumber;
	
	@Future(message = "validity date must be future date")
	private LocalDate validity;
	
	@Positive(message = "age must be positive")
	private Integer age;
	
	@Valid
	private PersonRequest personRequest;

}

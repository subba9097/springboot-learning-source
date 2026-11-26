package org.subbumaaya.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PassportResponse {

	private String passportNumber;

	private LocalDate validity;

	private Integer age;

}

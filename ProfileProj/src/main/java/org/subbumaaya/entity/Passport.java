package org.subbumaaya.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passports")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passport_id")
	private Long id;

	@Column(name = "passport_number", nullable = false, unique = true)
	private String passportNumber;

	@Column(name = "validity", nullable = false)
	private LocalDate validity;

	@Column(name = "age", nullable = false)
	private Integer age;
	
	@OneToOne(mappedBy = "passport" , cascade = CascadeType.PERSIST)
	private Person person;

}

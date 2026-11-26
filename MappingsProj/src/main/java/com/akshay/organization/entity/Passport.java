package com.akshay.organization.entity;

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
@Table(name = "passport")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passport_id")
	private Long id;

	@Column(name = "candidate_name", nullable = false)
	private String candidateName;

	@Column(name = "passport_number", nullable = false, unique = true)
	private String passportNumber;

}

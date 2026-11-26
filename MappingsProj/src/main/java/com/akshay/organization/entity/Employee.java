package com.akshay.organization.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long id;

	@Column(name = "employee_name" , nullable = false)
	private String name;

	@Column(name = "employee_email", nullable = false, unique = true)
	private String email;

	@Column(name = "employee_salary", nullable = false)
	private Double salary;

	@Column(name = "phone_number", nullable = false, unique = true)
	private String phoneNumber;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE , CascadeType.REMOVE})
	@JoinColumn(name = "passport_id" , referencedColumnName = "passport_id")
	private Passport passport;

}

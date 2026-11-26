package com.akshay.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.organization.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	boolean existsByEmail(String email);

	boolean existsByPhoneNumber(String phoneNumber);
}

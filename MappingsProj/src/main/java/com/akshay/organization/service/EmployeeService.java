package com.akshay.organization.service;

import java.util.List;

import com.akshay.organization.dto.EmployeeRequest;
import com.akshay.organization.dto.EmployeeResponse;
import com.akshay.organization.entity.Employee;

public interface EmployeeService {
	
	 Employee getEmployee(Long id);
	
	 List<Employee> getEmployees();
	
	 EmployeeResponse addEmployee(EmployeeRequest employee);
	
	Employee updateEmployee(Employee employee , Long id);
	
	void deleteEmployee(Long id);

}

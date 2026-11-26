package com.akshay.organization.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.akshay.organization.dto.EmployeeRequest;
import com.akshay.organization.dto.EmployeeResponse;
import com.akshay.organization.entity.Employee;
import com.akshay.organization.exception.DuplicatePhoneNumberException;
import com.akshay.organization.exception.EmailAlreadyExistsException;
import com.akshay.organization.exception.EmployeeNotFoundException;
import com.akshay.organization.repository.EmployeeRepository;
import com.akshay.organization.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public Employee getEmployee(Long id) {
		try {
			return employeeRepository.findById(id).get();
		} catch (Exception e) {
			throw new EmployeeNotFoundException("id not found");
		}
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
		
		if(employeeRepository.existsByEmail(employeeRequest.getEmail())) {
			throw new EmailAlreadyExistsException("email already exists");
		}
		
		if(employeeRepository.existsByPhoneNumber(employeeRequest.getPhoneNumber())) {
			throw new DuplicatePhoneNumberException("phone number already exists");
		}
		
		Employee savedEmployee =  employeeRepository.save(modelMapper.map(employeeRequest, Employee.class));
		
		return modelMapper.map(savedEmployee,EmployeeResponse.class);
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {

		Employee existingEmployee = getEmployee(id);

		if (employee.getName() != null)
			existingEmployee.setName(employee.getName());

		if (employee.getEmail() != null)
			existingEmployee.setEmail(employee.getEmail());

		if (employee.getPhoneNumber() != null)
			existingEmployee.setPhoneNumber(employee.getPhoneNumber());

		if (employee.getSalary() != null)
			existingEmployee.setSalary(employee.getSalary());
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {

		if (employeeRepository.existsById(id))
			employeeRepository.deleteById(id);

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found");

	}

}

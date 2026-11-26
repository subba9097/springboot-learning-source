package com.akshay.organization.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.organization.dto.EmployeeRequest;
import com.akshay.organization.dto.EmployeeResponse;
import com.akshay.organization.entity.Employee;
import com.akshay.organization.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(id));
//		return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
//		return ResponseEntity.ok(employeeService.getEmployee(id));
	}

	@GetMapping("all")
	public ResponseEntity<List<Employee>> getEmployees() {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployees());
//		return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<EmployeeResponse> addEmployee(@Valid	@RequestBody EmployeeRequest employeeRequestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employeeRequestDto));
//		return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee, id));
//		return new ResponseEntity<>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		return ResponseEntity.noContent().build();
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

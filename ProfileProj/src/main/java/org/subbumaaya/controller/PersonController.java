package org.subbumaaya.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.subbumaaya.dto.PersonRequest;
import org.subbumaaya.dto.PersonResponse;
import org.subbumaaya.service.PersonService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
	
	
	private final PersonService personService;
	
	@PostMapping("/add")
	public ResponseEntity<PersonResponse> addPersonDetails(@Valid @RequestBody PersonRequest personRequest){
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.addPersonDetails(personRequest));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonResponse> getPersonDetails(@PathVariable Long id){
		return ResponseEntity.ok(personService.getPersonDetails(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PersonResponse>> getPersonsDetails(){
		return ResponseEntity.ok(personService.getPersonsDetails());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePersonDetails(@PathVariable Long id){
		personService.deletePersonDetails(id);
		return ResponseEntity.noContent().build();
	}
	

}

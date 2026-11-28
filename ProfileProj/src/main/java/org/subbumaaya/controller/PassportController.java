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
import org.subbumaaya.dto.PassportRequest;
import org.subbumaaya.dto.PassportResponse;
import org.subbumaaya.service.PassportService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passport")
public class PassportController {

	private final PassportService passportService;

	@PostMapping("/add")
	public ResponseEntity<PassportResponse> addPassportDetails(@Valid @RequestBody PassportRequest passportRequest) {

		return ResponseEntity.status(HttpStatus.CREATED).body(passportService.addPassport(passportRequest));

	}

	@GetMapping("/{id}")
	public ResponseEntity<PassportResponse> getPassportDetails(@PathVariable Long id) {
		return ResponseEntity.ok(passportService.getPassportDetails(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<PassportResponse>> getAllPassportDetails() {
		return ResponseEntity.ok(passportService.getAllPassportDetails());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePassportDetails(@PathVariable Long id){
		passportService.deletePassport(id);
		return ResponseEntity.noContent().build();
	}

}

package org.subbumaaya.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
			HttpServletRequest req) {

		Map<String, String> errors = new HashMap<>();

		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

		for (FieldError error : fieldErrors)
			errors.put(error.getField(), error.getDefaultMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

}

package org.subbumaaya.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleProductAlreadyExistsException(ProductAlreadyExistsException ex,
			HttpServletRequest req) {

		ErrorResponse error = ErrorResponse.builder().timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value()).error(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.path(req.getServletPath()).message(ex.getMessage()).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}

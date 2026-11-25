package org.subbumaaya.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.subbumaaya.dto.ProductRequest;
import org.subbumaaya.dto.ProductResponse;
import org.subbumaaya.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping("/add/product")
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productRequest));
	}

}

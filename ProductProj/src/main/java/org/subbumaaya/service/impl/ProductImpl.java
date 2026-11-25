package org.subbumaaya.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.subbumaaya.dto.ProductRequest;
import org.subbumaaya.dto.ProductResponse;
import org.subbumaaya.dtoConversions.ProductConversion;
import org.subbumaaya.entity.Product;
import org.subbumaaya.exception.ProductAlreadyExistsException;
import org.subbumaaya.repository.ProductRepository;
import org.subbumaaya.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

	private final ProductRepository productRepository;

	private final ModelMapper modelMapper;

	@Override
	public ProductResponse getProduct(Long id) {
		return null;
	}

	@Override
	public List<ProductResponse> getProducts() {
		return null;
	}

	@Override
	public ProductResponse addProduct(ProductRequest productRequest) {

		if (productRepository.existsByName(productRequest.getName())) {
			throw new ProductAlreadyExistsException("product already exists");
		}
		Product product = modelMapper.map(productRequest, Product.class);

		Product savedProduct = productRepository.save(product);

		return modelMapper.map(savedProduct, ProductResponse.class);

//		Product product = productConversion.productRequestToProduct(productRequest);
//		 return productConversion.productToProductResponse(savedProduct);

	}

	@Override
	public ProductResponse partialUpdateProduct(ProductRequest productRequest, Long id) {
		return null;
	}

	@Override
	public ProductResponse updateProduct(ProductRequest productRequest, Long id) {
		return null;
	}

	@Override
	public void deleteProduct(Long id) {

	}

}

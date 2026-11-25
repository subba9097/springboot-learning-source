package org.subbumaaya.service;

import java.util.List;

import org.subbumaaya.dto.ProductRequest;
import org.subbumaaya.dto.ProductResponse;

public interface ProductService {
	
	ProductResponse getProduct(Long id);
	List<ProductResponse> getProducts();
	ProductResponse addProduct(ProductRequest productRequest);
	ProductResponse partialUpdateProduct(ProductRequest productRequest,Long id);
	ProductResponse updateProduct(ProductRequest productRequest,Long id);
	void deleteProduct(Long id);

}

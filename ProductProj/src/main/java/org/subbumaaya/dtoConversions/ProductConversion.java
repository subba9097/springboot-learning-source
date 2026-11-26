package org.subbumaaya.dtoConversions;

import org.springframework.stereotype.Component;
import org.subbumaaya.dto.ProductRequest;
import org.subbumaaya.dto.ProductResponse;
import org.subbumaaya.entity.Product;

@Component
public class ProductConversion {

//	public  Product productRequestToProduct(ProductRequest productRequest) {
//		Product product = new Product();
//		product.setName(productRequest.getProductName());
//		product.setPrice(productRequest.getPrice());
//		product.setIngridiants(productRequest.getIngridiants());
//		product.setExpiryDate(productRequest.getProductExpiryDate());
//		return product;
//	}
//
//	public  ProductResponse productToProductResponse(Product product) {
//		return ProductResponse.builder().id(product.getId()).name(product.getName()).price(product.getPrice())
//				.ingridiants(product.getIngridiants()).build();
//	}

}

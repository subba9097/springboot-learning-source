package org.subbumaaya.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.subbumaaya.dto.ProductRequest;
import org.subbumaaya.dto.ProductResponse;
import org.subbumaaya.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	@Mappings({ @Mapping(source = "productName", target = "name"),
			@Mapping(source = "productPrice", target = "price") ,@Mapping(target="id" , ignore = true)})
	Product toProduct(ProductRequest productRequest);

	ProductResponse toProductResposne(Product product);

}

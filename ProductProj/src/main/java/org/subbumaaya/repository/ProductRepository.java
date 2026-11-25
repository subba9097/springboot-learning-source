package org.subbumaaya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.subbumaaya.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	
	boolean existsByName(String name);

}

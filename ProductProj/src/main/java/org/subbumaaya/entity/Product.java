package org.subbumaaya.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	
	@Column(name = "product_name" , nullable = false ,unique = true)
	private String name;
	
	@Column(name = "product_price" , nullable =  false)
	private Double price;
	
	@Column(name = "product_ingridiants" , nullable = false)
	private List<String> ingridiants;
	
	@Column(name = "product_expiry" ,nullable = false)
	private String expiryDate;

}

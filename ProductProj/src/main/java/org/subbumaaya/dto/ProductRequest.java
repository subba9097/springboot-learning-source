package org.subbumaaya.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
	
	private String name;
	
	private Double price;
	
	private List<String> ingridiants;
	
	private String expiryDate;
	
}

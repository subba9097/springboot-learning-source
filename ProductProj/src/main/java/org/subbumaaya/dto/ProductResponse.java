package org.subbumaaya.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
	
	private Long id;
	
	private String name;
	
	private Double price;
	
	private List<String> ingridiants;
	

}

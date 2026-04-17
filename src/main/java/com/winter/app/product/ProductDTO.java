package com.winter.app.product;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDTO {
	
	private Long productNum;
	private String productName;
	private String productContents;
	private String productType;
	private Double productRate;
	private List<ProductFileDTO> list;

}

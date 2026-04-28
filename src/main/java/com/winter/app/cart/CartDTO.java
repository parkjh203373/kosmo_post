package com.winter.app.cart;

import com.winter.app.product.ProductDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CartDTO {
	
	private String username;
	private Long productNum;
	
	private ProductDTO productDTO;

}

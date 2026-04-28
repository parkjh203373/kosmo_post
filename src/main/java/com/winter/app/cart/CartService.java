package com.winter.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	public int create(CartDTO cartDTO) throws Exception {
		
		return cartMapper.create(cartDTO);
	}
	
	public List<CartDTO> list(CartDTO cartDTO) throws Exception {
		
		return cartMapper.list(cartDTO);
	}

}

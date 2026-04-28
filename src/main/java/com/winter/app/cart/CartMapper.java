package com.winter.app.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
	
	public abstract int create(CartDTO cartDTO) throws Exception;
	
	public abstract List<CartDTO> list(CartDTO cartDTO) throws Exception;

}

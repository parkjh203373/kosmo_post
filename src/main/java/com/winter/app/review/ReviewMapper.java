package com.winter.app.review;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
	
	public int create(ReviewDTO reviewDTO) throws Exception;
	
	public List<ReviewDTO> list(ReviewDTO reviewDTO) throws Exception;

}

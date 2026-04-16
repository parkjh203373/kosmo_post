package com.winter.app.board;

import java.util.List;

public interface BoardMapper {
	
	//CRUD
	
	//Read
	//list, detail
	public List<BoardDTO> list() throws Exception;
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//Create
	public int create(BoardDTO boardDTO) throws Exception;
	
	//Update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//Delete
	public int delete(BoardDTO boardDTO) throws Exception;

}

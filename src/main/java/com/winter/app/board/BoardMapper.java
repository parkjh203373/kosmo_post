package com.winter.app.board;

import java.util.List;

public interface BoardMapper {
	
	//CRUD
	
	//Read
	public List<BoardDTO> list() throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//Create
	
	//Update
	
	//Delete

}

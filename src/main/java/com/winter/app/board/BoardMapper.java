package com.winter.app.board;

import java.util.List;

import com.winter.app.file.FileDTO;
import com.winter.app.pager.Pager;

public interface BoardMapper {
	
	public Long getCount(Pager pager) throws Exception;
	
	public int createFile(FileDTO fileDTO) throws Exception;
	
	//CRUD
	
	//Read
	//list, detail
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//Create
	public int create(BoardDTO boardDTO) throws Exception;
	
	//Update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//Delete
	public int delete(BoardDTO boardDTO) throws Exception;
	
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception;
	

}

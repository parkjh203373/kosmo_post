package com.winter.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.winter.app.pager.Pager;

public interface BoardService {
	
	//Read
	//list, detail
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//Create
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;
	
	//Update
	public int update(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;
	
	//Delete
	public int delete(BoardDTO boardDTO) throws Exception;

}

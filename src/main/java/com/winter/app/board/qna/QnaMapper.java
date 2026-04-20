package com.winter.app.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.board.BoardMapper;
import com.winter.app.file.FileDTO;

@Mapper
public interface QnaMapper extends BoardMapper {
	
	public int fileDelete(FileDTO fileDTO) throws Exception;
	
	public int fileDeleteFor(List<FileDTO> list) throws Exception;

}

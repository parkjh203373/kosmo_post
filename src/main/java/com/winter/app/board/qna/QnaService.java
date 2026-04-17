package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.file.FileManager;
import com.winter.app.pager.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaMapper qnaMapper;
	@Value("${app.board.qna}")
	private String name;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makePageNum(qnaMapper.getCount(pager));
		pager.makeStartNum();

		return qnaMapper.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {

		return null;
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		int result = qnaMapper.create(boardDTO);
		
		if(attach==null) {
			return result;
		}
		
		for(MultipartFile f:attach) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(name, f);
			
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setOriName(f.getOriginalFilename());
			qnaFileDTO.setBoardNum(boardDTO.getBoardNum());
			qnaFileDTO.setFileName(fileName);
			
			result = qnaMapper.createFile(qnaFileDTO);
			
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {

		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {

		return 0;
	}
	
	

}

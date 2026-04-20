package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.file.FileDTO;
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

		return qnaMapper.detail(boardDTO);
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
	public int update(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		int result = qnaMapper.update(boardDTO);

		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		boardDTO = qnaMapper.detail(boardDTO);
		
		for(FileDTO fileDTO:boardDTO.getList()) {
			fileManager.fileDelete(name, fileDTO);
			//qnaMapper.fileDelete(fileDTO);
			qnaMapper.fileDeleteFor(boardDTO.getList());
		}
		
		int result = qnaMapper.delete(boardDTO);

		return result;
	}
	
	

}

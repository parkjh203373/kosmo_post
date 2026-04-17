package com.winter.app.board.notice;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.board.notice}")
	private String name;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makePageNum(noticeMapper.getCount(pager));
		pager.makeStartNum();
		
		return noticeMapper.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {

		return null;
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		//1. 게시판 테이블에 글 추가
		int result = noticeMapper.create(boardDTO);
		
		if(attach==null) {
			return result;
		}
		
		//2. 파일을 하드디스크에 저장
		for(MultipartFile f:attach) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(name, f);
			
			//3. 파일의 정보들을 DB에 저장
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setOriName(f.getOriginalFilename());
			noticeFileDTO.setBoardNum(boardDTO.getBoardNum());
			noticeFileDTO.setFileName(fileName);
			
			result = noticeMapper.createFile(noticeFileDTO);
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

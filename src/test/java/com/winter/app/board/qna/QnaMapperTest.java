package com.winter.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.winter.app.board.BoardDTO;
import com.winter.app.pager.Pager;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class QnaMapperTest {
	
	@Autowired
	private QnaMapper qnaMapper;

	@Test
	void testList() throws Exception {
		Pager pager = new Pager();
		pager.setSearch("8");
		pager.setPage(2L);
		pager.makeStartNum();
		List<BoardDTO> ar = qnaMapper.list(pager);
		log.info("{}", ar);
		assertEquals(5, ar.size());
	}
	
	//@Test
	void testCreate() throws Exception {
		for(int i=0; i<23; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setBoardTitle("qna title"+i);
			qnaDTO.setBoardWriter("qna writer"+i);
			qnaDTO.setBoardContents("qna contents"+i);
			qnaMapper.create(qnaDTO);
			
			if(i%3==0) {
				Thread.sleep(1000);
			}
			
		}
		
		System.out.println("finish");
		
	}
	

}

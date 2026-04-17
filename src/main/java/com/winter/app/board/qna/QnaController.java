package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.pager.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = qnaService.list(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@GetMapping("create")
	public String create() throws Exception {
		
		return "board/create";
	}
	
	@PostMapping("create")
	public String create(QnaDTO qnaDTO, @RequestParam("attach") MultipartFile[] attach) throws Exception {
		int result = qnaService.create(qnaDTO, attach);
		
		return "redirect:./list";
	}

}

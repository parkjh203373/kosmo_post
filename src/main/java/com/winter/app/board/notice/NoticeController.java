package com.winter.app.board.notice;

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

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = noticeService.list(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@GetMapping("create")
	public String create() throws Exception {
		
		return "board/create";
	}
	
	@PostMapping("create")
	public String create(NoticeDTO noticeDTO, @RequestParam("attach") MultipartFile[] attach) throws Exception {
		int result = noticeService.create(noticeDTO, attach);
		
		return "redirect:./list";
	}

}

package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@Value("${app.board.notice}")
	private String name;
	
	@ModelAttribute("name")
	public String getName() {
		return this.name;
	}
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = noticeService.list(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("d", boardDTO);
		
		return "board/detail";
		
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
	
	@GetMapping("update")
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("d", boardDTO);
		
		return "board/update";
	}
	
	@PostMapping("update")
	public String update(NoticeDTO noticeDTO, @RequestParam("attach") MultipartFile[] attach) throws Exception {
		int result = noticeService.update(noticeDTO, attach);
		
		return "redirect:./list";
	}
	
	@PostMapping("delete")
	public String delete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
		
		return "redirect:./list";
	}

}

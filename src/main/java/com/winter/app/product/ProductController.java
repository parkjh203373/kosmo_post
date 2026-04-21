package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.pager.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Value("${app.product.image}")
	private String name; // "product"가 담김
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
		List<ProductDTO> ar = productService.list(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
	    model.addAttribute("name", name);
		
		
		return "product/list";
		
	}
	
	@GetMapping("detail")
	public String detail(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.detail(productDTO);
		model.addAttribute("d", productDTO);
		
		return "product/detail";
		
	}
	
	@GetMapping("create")
	public String create() throws Exception {
		
		return "product/create";
	}
	
	@PostMapping("create")
	public String create(ProductDTO productDTO, @RequestParam("attach") MultipartFile attach) throws Exception {
		int result = productService.create(productDTO, attach);
		
		return "redirect:./list";
	}

}

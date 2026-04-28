package com.winter.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winter.app.member.MemberDTO;
import com.winter.app.pager.Pager;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	
	@Value("${app.product.image}")
	private String name;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("create")
	public String create(HttpSession session, CartDTO cartDTO, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");

		cartDTO.setUsername(memberDTO.getUsername());
		int result = cartService.create(cartDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
		
	}
	
	@GetMapping("list")
	public String list(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		if(memberDTO==null) {
			return "redirect:../member/login";
		}
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setUsername(memberDTO.getUsername());
		
		List<CartDTO> ar = cartService.list(cartDTO);
		model.addAttribute("list", ar);
	    model.addAttribute("name", name);
		
		return "cart/list";
		
	}

}

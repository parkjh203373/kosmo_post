package com.winter.app.interceptors;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardMapper;
import com.winter.app.member.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class WriterCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
//		if(request.getMethod().toUpperCase().equals("POST")) {
//			return;
//		}
		
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		//ModelAndView
		Map<String, Object> model = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)model.get("d");
		
		boolean flag = memberDTO.getUsername().equals(boardDTO.getBoardWriter());
		if(!flag) {
			modelAndView.setViewName("commons/result");
			modelAndView.addObject("result", "작성자만 가능");
			modelAndView.addObject("url", "./list");
		}
		
	}

}

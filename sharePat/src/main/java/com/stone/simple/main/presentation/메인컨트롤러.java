package com.stone.simple.main.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class 메인컨트롤러 {
	@GetMapping("/main")
	public ModelAndView 메인페이지를주다(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/메인");		
		boolean 로그인중=(session.getAttribute("member_id")!=null)?true:false;
		mv.addObject("isLogin",로그인중);
		return mv;
	}
}

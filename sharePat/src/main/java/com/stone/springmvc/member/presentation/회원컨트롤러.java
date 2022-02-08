package com.stone.springmvc.member.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.member.common.Member;
import com.stone.springmvc.member.service.*;

@Controller
public class 회원컨트롤러 {
	@Autowired 회원업무자 회원업무자;
	
	@GetMapping("/id")
	public String Id중복검사준비하다(){
		return "아이디중복검사창";
	}
	
	@PostMapping("/id")	
	ModelAndView Id중복검사하다(String member_id){
		
		boolean 아이디사용가능여부= 회원업무자.아이디사용가능여부를판단하다(member_id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("아이디중복검사창");
		mv.addObject("member_id", member_id);
		mv.addObject("usable", 아이디사용가능여부);
		return mv;
	}

	@GetMapping("/assign")
	public String 회원등록준비하다() {
		if(회원업무자.회원등록준비가능한가()) {
			return "회원등록창";
		}		
		return null;
	}
	@PostMapping("/assign")	
	public ModelAndView 회원등록하다(Member 새회원) {
		
		회원업무자.저장하다(새회원);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("member_name", 새회원.getMember_name());
		mv.setViewName("회원등록알림창");
		return mv;
	}
	
	//로그인 했어야지만 할 수 있는 요청
	@GetMapping("/member")
	public ModelAndView 회원자신의정보를보다() {		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/Test자기정보창");
		return mv;
	}
	
	@GetMapping("/member/{member_no}")// 예) /member/1
	public ModelAndView 회원조회하다(@PathVariable("member_no") int member_no, HttpSession session){
		Member 찾은회원 = 회원업무자.회원정보를조회하다(member_no);
		ModelAndView mv=new ModelAndView();
		mv.addObject("member", 찾은회원);
		mv.setViewName("member/회원정보창");
		return mv;
	}
}


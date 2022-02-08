package com.stone.springmvc.shareNote.presentation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.member.common.Member;
import com.stone.springmvc.shareNote.common.ShareNote;
import com.stone.springmvc.shareNote.service.I분양업무자;

@Controller
public class 분양컨트롤러 { 
	@Autowired I분양업무자 분양업무자;
	
	@GetMapping("/shareNote")
	public String 분양작성을준비하다() {
		if(분양업무자.분양작성이가능한가()) {		
			return "shareNote/분양등록창";
		}
		return null;//실제는 작성이 불가 안내 창
	}
	
	@PostMapping("/shareNote")
	public String 분양을등록하다(ShareNote 새분양, HttpSession session) {
		//로그인한 회원의 번호 구해야함-로그인 당시 회원번호를   setAttribute 했다는 것을 전제로 할때
		int 로그인한회원의번호=(int)session.getAttribute("회원번호");
		//로그인한 회원이 작성자이므로 새게시물에 작성자를 set 해주어야함
		Member 작성한회원=new Member();
		작성한회원.setMember_no(로그인한회원의번호);
		새분양.setWriter(작성한회원);
		
		분양업무자.분양을등록하다(새분양);
		return "shareNote/분양등록알림창";
	}
	
	@GetMapping("/shareNotes")
	public ModelAndView 분양목록을출력하다() {
		List<ShareNote> 수집된분양들 = 분양업무자.모든분양을수집하다();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("shareNote/분양목록창");
		mv.addObject("shareNotes", 수집된분양들);
		return mv;
	}
	@GetMapping("/shareNote/{분양번호}")
	public ModelAndView 분양상세츨력하다(@PathVariable int 분양번호,HttpSession session) {
		ShareNote 찾은분양=분양업무자.분양을조회하다(분양번호);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("shareNote/분양상세창");
		mv.addObject("shareNote",찾은분양);
		//로그인 안되어 있으면=>  로그인회원와게시물작성자가동일인물인가=null
		Boolean 로그인회원와분양작성자가동일인물인가=null;
	    if(session!=null) {
	    	Integer 회원번호=(Integer)session.getAttribute("회원번호");
	    	 if(회원번호!=null) { //로그인된 경우
	    		 //로그인 회원와 게시물 작성자가 동일 인물
	    		 if(회원번호==찾은분양.getWriter().getMember_no()) {
	    			 로그인회원와분양작성자가동일인물인가=true;
	    		 }
	    		 else //로그인 회원와 게시물 작성자가 다른 인물
	    		 {
	    			 로그인회원와분양작성자가동일인물인가=false;
	    		 }
	    	 }
	    }
	    
		mv.addObject("isWriter", 로그인회원와분양작성자가동일인물인가);
		return mv;
	}
	
	@GetMapping("/shareNote/{분양번호}/prepare_update")
	public ModelAndView 분양을변경준비하다(@PathVariable int 분양번호,HttpSession session){
		ShareNote 찾은분양 = 분양업무자.분양을변경준비하다(분양번호); 
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("shareNote/분양변경창"); 
		mv.addObject("shareNote", 찾은분양);
		return mv;
	}
	
	@PostMapping("/shareNote/update")
	public ModelAndView 분양을변경하다(ShareNote shareNote,HttpSession session) {
	
		분양업무자.분양을변경하다(shareNote);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("shareNote/분양변경알림창");
		return mv;
	}
	
	@GetMapping("/shareNote/{분양번호}/delete")
	public ModelAndView 분양을삭제하다(@PathVariable int 분양번호,HttpSession session){
		분양업무자.분양을삭제하다(분양번호);
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("shareNote/분양삭제통보창"); 
		return mv;
	}
}
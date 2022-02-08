package com.stone.springmvc.story.presentation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.member.common.Member;
import com.stone.springmvc.story.common.Story;
import com.stone.springmvc.story.service.I스토리업무자;

@Controller
public class 스토리컨트롤러 { 
	@Autowired I스토리업무자 스토리업무자;
	
	@GetMapping("/story")
	public String 스토리작성을준비하다() {
		if(스토리업무자.스토리작성이가능한가()) {		
			return "story/스토리등록창";
		}
		return null;//실제는 작성이 불가 안내 창
	}
	
	@PostMapping("/story")
	public String 스토리을등록하다(Story 새스토리, HttpSession session) {
		//로그인한 회원의 번호 구해야함-로그인 당시 회원번호를   setAttribute 했다는 것을 전제로 할때
		int 로그인한회원의번호=(int)session.getAttribute("회원번호");
		//로그인한 회원이 작성자이므로 새게시물에 작성자를 set 해주어야함
		Member 작성한회원=new Member();
		작성한회원.setMember_no(로그인한회원의번호);
		새스토리.setWriter(작성한회원);
		
		스토리업무자.스토리을등록하다(새스토리);
		return "story/스토리등록알림창";
	}
	
	@GetMapping("/storys")
	public ModelAndView 스토리목록을출력하다() {
		List<Story> 수집된스토리들 = 스토리업무자.모든스토리을수집하다();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("story/스토리목록창");
		mv.addObject("storys", 수집된스토리들);
		return mv;
	}
	@GetMapping("/story/{스토리번호}")
	public ModelAndView 스토리상세츨력하다(@PathVariable int 스토리번호,HttpSession session) {
		Story 찾은스토리=스토리업무자.스토리을조회하다And조회수증가하다(스토리번호);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("story/스토리상세창");
		mv.addObject("story",찾은스토리);
		//로그인 안되어 있으면=>  로그인회원와게시물작성자가동일인물인가=null
		Boolean 로그인회원와스토리작성자가동일인물인가=null;
	    if(session!=null) {
	    	Integer 회원번호=(Integer)session.getAttribute("회원번호");
	    	 if(회원번호!=null) { //로그인된 경우
	    		 //로그인 회원와 게시물 작성자가 동일 인물
	    		 if(회원번호==찾은스토리.getWriter().getMember_no()) {
	    			 로그인회원와스토리작성자가동일인물인가=true;
	    		 }
	    		 else //로그인 회원와 게시물 작성자가 다른 인물
	    		 {
	    			 로그인회원와스토리작성자가동일인물인가=false;
	    		 }
	    	 }
	    }
	    
		mv.addObject("isWriter", 로그인회원와스토리작성자가동일인물인가);
		return mv;
	}

	@GetMapping("/story/{스토리번호}/prepare_update")
	public ModelAndView 스토리을변경준비하다(@PathVariable int 스토리번호,HttpSession session){
		Story 찾은스토리 = 스토리업무자.스토리을변경준비하다(스토리번호); 
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("story/스토리변경창"); 
		mv.addObject("story", 찾은스토리);
		return mv;
	}
	
	@PostMapping("/story/update")
	public ModelAndView 스토리을변경하다(Story story,HttpSession session) {
	
		스토리업무자.스토리을변경하다(story);
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("story/스토리변경알림창");
		return mv;
	}
	
	@GetMapping("/story/{스토리번호}/delete")
	public ModelAndView 스토리을삭제하다(@PathVariable int 스토리번호,HttpSession session){
		스토리업무자.스토리을삭제하다(스토리번호);
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("story/스토리삭제통보창"); 
		return mv;
	}
}
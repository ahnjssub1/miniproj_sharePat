package com.stone.springmvc.shareNote.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.shareNote.common.ShareNote;
import com.stone.springmvc.shareNote.service.I분양업무자;

@Controller
public class 분양사진 {
	@Autowired I분양업무자 분양업무자; 
	 
	@GetMapping("/profile/{분양번호}")  // 예 /profile/1
	ModelAndView 프로필사진을주다(@PathVariable("분양번호") int share_no){
		
		ShareNote 뷴양= 분양업무자.분양을조회하다(share_no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("share_profile");
		mv.addObject("share_profile",뷴양.getShare_profile());
		return mv;
	}
}

package com.stone.springmvc.story.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.story.common.Story;
import com.stone.springmvc.story.service.I스토리업무자;

@Controller
public class 스토리사진 {
	@Autowired I스토리업무자 스토리업무자; 
	 
	@GetMapping("/profile/{스토리번호}")  // 예 /profile/1
	ModelAndView 프로필사진을주다(@PathVariable("스토리번호") int story_no){
		
		Story 스토리= 스토리업무자. 스토리을조회하다And조회수증가하다(story_no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("story_profile");
		mv.addObject("story_profile",스토리.getStory_profile());
		return mv;
	}
}


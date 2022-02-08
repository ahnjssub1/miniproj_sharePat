package com.stone.springmvc.story.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.springmvc.story.common.Story;
import com.stone.springmvc.story.dataservice.I스토리DAO;

@Service
public class 스토리업무자 implements I스토리업무자 {
    @Autowired I스토리DAO 스토리DAO;

	@Override
	public boolean 스토리작성이가능한가() {
		return true;
	}

	@Override
	public void 스토리을등록하다(Story 새스토리) {
		스토리DAO.저장하다(새스토리);
	}

	@Override
	public List<Story> 모든스토리을수집하다() {
		return 스토리DAO.모든스토리을수집하다();
	}

	@Override
	public Story 스토리을조회하다And조회수증가하다(int 스토리번호) {
		return 스토리DAO.스토리을찾다And조회수증가하다(스토리번호);
	}
	
	@Override
	public Story 스토리을변경준비하다(int 스토리번호) {
		return 스토리DAO.스토리을찾다And조회수증가하다(스토리번호);
	}

	@Override
	public void 스토리을변경하다(Story story) {
		스토리DAO.변경하다(story);		
	}

	@Override
	public void 스토리을삭제하다(int 스토리번호) {
		스토리DAO.삭제하다(스토리번호);
		
	}
}
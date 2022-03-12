package com.stone.springmvc.story.service;

import java.util.List;

import com.stone.springmvc.story.common.Story;

public interface I스토리업무자 {
	public  boolean 스토리작성이가능한가();	
	public void 스토리을등록하다(Story 새스토리);
	public List<Story> 모든스토리을수집하다();
	public Story 스토리을조회하다And조회수증가하다(int 스토리번호);
	public Story 사진찾다(int 스토리번호);
	public Story 스토리을변경준비하다(int 스토리번호);
	public void 스토리을변경하다(Story story);
	public void 스토리을삭제하다(int 스토리번호);
}


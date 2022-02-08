package com.stone.springmvc.story.dataservice;

import java.util.List;

import com.stone.springmvc.story.common.Story;

public interface I스토리DAO {
	public  void  저장하다(Story 새스토리);
	public List<Story> 모든스토리을수집하다();
	public Story 스토리을찾다And조회수증가하다(int 스토리번호);
	public void 삭제하다(int 스토리번호);
	public void 변경하다(Story 변경할스토리);
}

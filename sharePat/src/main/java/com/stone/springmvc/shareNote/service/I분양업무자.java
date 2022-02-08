package com.stone.springmvc.shareNote.service;

import java.util.List;

import com.stone.springmvc.shareNote.common.ShareNote;

public interface I분양업무자 {
	public  boolean 분양작성이가능한가();	
	public void 분양을등록하다(ShareNote 새분양);
	public List<ShareNote> 모든분양을수집하다();
	public ShareNote 분양을조회하다(int 분양번호);
	public ShareNote 분양을변경준비하다(int 분양번호);
	public void 분양을변경하다(ShareNote shareNote);
	public void 분양을삭제하다(int 분양번호);
}

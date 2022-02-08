package com.stone.springmvc.shareNote.dataservice;

import java.util.List;

import com.stone.springmvc.shareNote.common.ShareNote;

public interface I분양DAO {
	public  void  저장하다(ShareNote 새분양);
	public List<ShareNote> 모든분양을수집하다();
	public ShareNote 분양을찾다(int 분양번호);
	public void 삭제하다(int 분양번호);
	public void 변경하다(ShareNote 변경할분양);
	
}

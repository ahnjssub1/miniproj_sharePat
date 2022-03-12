package com.stone.springmvc.shareNote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.springmvc.shareNote.common.ShareNote;
import com.stone.springmvc.shareNote.dataservice.I분양DAO;

@Service
public class 분양업무자  implements I분양업무자{
	@Autowired I분양DAO 분양DAO;
	@Override
	public boolean 분양작성이가능한가() {
		
		return true;
	}

	@Override
	public void 분양을등록하다(ShareNote 새분양) {
		분양DAO.저장하다(새분양);		
	}

	@Override
	public List<ShareNote> 모든분양을수집하다() {
		return 분양DAO.모든분양을수집하다();
	}
	
	@Override
	public ShareNote 분양을조회하다(int 분양번호) {
		
		return 분양DAO.분양을찾다(분양번호);
	}
	@Override
	public ShareNote 분양을변경준비하다(int 분양번호) {
		return 분양DAO.분양을찾다(분양번호);
	}
	@Override
	public void 분양을변경하다(ShareNote 변경할분양) {
		분양DAO.변경하다(변경할분양);
	}
	@Override
	public void 분양을삭제하다(int 분양번호) {
	
		분양DAO.삭제하다(분양번호);
	}
}

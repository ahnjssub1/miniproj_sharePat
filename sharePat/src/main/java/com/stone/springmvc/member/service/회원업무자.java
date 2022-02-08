package com.stone.springmvc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.springmvc.member.common.Member;
import com.stone.springmvc.member.dataservice.*;

@Service
public class 회원업무자 {
	@Autowired I회원DAO 회원DAO; 
	
	public boolean  아이디사용가능여부를판단하다(String member_id) {
		
		return !회원DAO.있는가(member_id);
	}
	public boolean 회원등록준비가능한가() {
		
		return true;
	}
	public void 저장하다(Member 새회원) {
		회원DAO.저장하다(새회원);
	}
	
	public Member 조회하다(String member_id, String  member_pw) {
		return 회원DAO.찾다ById와Password(member_id, member_pw);
	}
	
	public Member 회원정보를조회하다(int member_no) {
		return 회원DAO.찾다By회원번호(member_no);
	}
}

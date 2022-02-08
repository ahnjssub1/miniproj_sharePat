package com.stone.springmvc.member.dataservice;

import com.stone.springmvc.member.common.Member;

public interface I회원DAO {
	
	public boolean 있는가(String member_id);
	public void 저장하다(Member 새회원);
	Member 찾다ById와Password(String member_id, String member_pw);
	Member 찾다By회원번호(int member_no);
}

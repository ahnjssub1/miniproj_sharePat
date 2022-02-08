package com.stone.springmvc.member.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.stone.springmvc.member.common.Member;

import config.DBConfig;

@Repository
public class 회원DAO implements I회원DAO{

	public boolean 있는가(String member_id) {
		boolean 있다=  false;
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("select count(*) from member where member_id=?");
	        명령자.setString(1, member_id);
	        ResultSet 있냐표 =명령자.executeQuery();
	        if(있냐표.next()) {
	        	if(있냐표.getInt(1)==1) {
	        		있다=true;
	        	}
	        }
	        있냐표.close();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	    return 있다;
	}
	
	public void 저장하다(Member 새회원) {
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("insert into member(member_id,member_pw,member_name,member_email,member_phone) values(?,?,?,?,?)");
	        명령자.setString(1, 새회원.getMember_id());
	        명령자.setString(2, 새회원.getMember_pw());
	        명령자.setString(3, 새회원.getMember_name());
	        명령자.setString(4, 새회원.getMember_email());
	        명령자.setString(5, 새회원.getMember_phone());
	        명령자.executeUpdate();	         
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }		
	    System.out.println(새회원.getMember_id());
	    System.out.println(새회원.getMember_email());

	}
	
	@Override
	public Member 찾다ById와Password(String member_id, String member_pw) {

	    Member 찾은회원=null; 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("select member_no, member_name from member where member_id=? and member_pw=?");
	        명령자.setString(1, member_id);
	        명령자.setString(2, member_pw);
	        ResultSet 회원표 =명령자.executeQuery();
	        if(회원표.next()) {
	        	int 회원번호=회원표.getInt("member_no");
	        	String 성명=회원표.getString("member_name");
	        	찾은회원=new Member();
	        	찾은회원.setMember_no(회원번호);
	        	찾은회원.setMember_name(성명);
	        }
	        회원표.close();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
		return 찾은회원;
	}

	@Override
	public Member 찾다By회원번호(int member_no) {
		Member 찾은회원=null; 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("select member_no,member_id,member_name,member_email,member_phone from member where member_no=?");
	        명령자.setInt(1, member_no);
	        ResultSet 회원표 =명령자.executeQuery();
	        if(회원표.next()) {
	        	int 회원번호=회원표.getInt("member_no");
	        	String id=회원표.getString("member_id");
	        	String 성명=회원표.getString("member_name");
	        	String email=회원표.getString("member_email");
	        	String phone=회원표.getString("member_phone");
	        	찾은회원=new Member();
	        	찾은회원.setMember_no(회원번호);
	            찾은회원.setMember_id(id);
	            찾은회원.setMember_name(성명);
	            찾은회원.setMember_email(email);
	            찾은회원.setMember_phone(phone);
	        }
	        회원표.close();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
		return 찾은회원;
	}

}

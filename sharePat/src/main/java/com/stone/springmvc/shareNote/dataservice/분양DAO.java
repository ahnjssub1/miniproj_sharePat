package com.stone.springmvc.shareNote.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stone.springmvc.member.common.Member;
import com.stone.springmvc.member.dataservice.I회원DAO;
import com.stone.springmvc.shareNote.common.ShareNote;

import config.DBConfig;

@Repository
public class 분양DAO implements I분양DAO{
	@Autowired I회원DAO 회원DAO;
	@Override
	public void 저장하다(ShareNote 새분양) {
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("insert into shareNote(share_title, share_contents, share_profile, writer) values(?,?,?,?)");
	        명령자.setString(1, 새분양.getShare_title());
	        명령자.setString(2, 새분양.getShare_contents());
	        명령자.setBytes(3, 새분양.getShare_profile());
	        명령자.setInt(4, 새분양.getWriter().getMember_no());//작성자 회원의 번호를 준다
	        명령자.executeUpdate();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
		System.out.println(새분양.getShare_time());
	}

	@Override
	public List<ShareNote> 모든분양을수집하다() {
		List<ShareNote> 수집된분양들 = new ArrayList<ShareNote>(); 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("select share_no,share_title, share_time,writer from shareNote");
	        ResultSet 게시물표= 명령자.executeQuery();
	        while(게시물표.next()) {
	        	int no = 게시물표.getInt("share_no");
	        	String title=게시물표.getString("share_title");
	        	Timestamp time = 게시물표.getTimestamp("share_time");
	        	int 작성한회원의번호 = 게시물표.getInt("writer");	        	
	        	Member 작성한회원 = 회원DAO.찾다By회원번호(작성한회원의번호);
	        	
	        	ShareNote 분양=new ShareNote();
	        	분양.setShare_no(no);
	        	분양.setShare_title(title);
	        	분양.setShare_time(time);
	        	분양.setWriter(작성한회원);//주목
	        	
	        	수집된분양들.add(분양);
	        }
	    }
		catch(Exception ex){ ex.printStackTrace(); }
		return 수집된분양들;
	}


	@Override
	public ShareNote 분양을찾다(int 분양번호) {
		ShareNote 분양 = null; 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("select share_no,share_title,share_contents,share_profile,share_time,writer from shareNote where share_no=?");
	        명령자.setInt(1, 분양번호);
	        ResultSet 게시물표= 명령자.executeQuery();
	        if(게시물표.next()) {
	        	int no = 게시물표.getInt("share_no");
	        	String title=게시물표.getString("share_title");
	        	String contents =게시물표.getString("share_contents");
	        	byte[] profile=게시물표.getBytes("share_profile");
	        	Timestamp time = 게시물표.getTimestamp("share_time");
	        	int 작성한회원의번호 = 게시물표.getInt("writer");	        	
	        	Member 작성한회원 = 회원DAO.찾다By회원번호(작성한회원의번호);
	        	
	        	분양=new ShareNote();
	        	분양.setShare_no(no);
	        	분양.setShare_title(title);
	        	분양.setShare_contents(contents);
	        	분양.setShare_profile(profile);
	        	분양.setShare_time(time);
	        	분양.setWriter(작성한회원);//주목
	        }
	    }
		catch(Exception ex){ ex.printStackTrace(); }
		return 분양;
	}
	
	@Override
	public void 변경하다(ShareNote 변경할분양) {
		Connection con = null;		 
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
		        
	        PreparedStatement 명령자=con.prepareStatement("update shareNote set share_title=?, share_contents=?, share_time=? where share_no=?"); 
	        명령자.setString(1, 변경할분양.getShare_title());
	        명령자.setString(2, 변경할분양.getShare_contents());
	        명령자.setTimestamp(3, 변경할분양.getShare_time());
	        명령자.setInt(4, 변경할분양.getWriter().getMember_no());

	        명령자.executeUpdate();
	        
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }		
	}
	
	@Override
	public void 삭제하다(int 분양번호) {
		Connection con = null;		 
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
		    
	        PreparedStatement 명령자=con.prepareStatement("delete from shareNote where share_no=?"); 
	        명령자.setInt(1, 분양번호);
	        명령자.executeUpdate();
	        
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }		
	}
	
}

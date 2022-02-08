package com.stone.springmvc.story.dataservice;

import java.sql.Connection;
import java.sql.Date;
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
import com.stone.springmvc.story.common.Story;

import config.DBConfig;

@Repository
public class 스토리DAO implements I스토리DAO {
	@Autowired I회원DAO 회원DAO;

	@Override
	public void 저장하다(Story 새스토리) {
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("insert into story(story_title,story_contents,story_profile,story_time,writer) values(?,?,?,?,?)");
	        명령자.setString(1, 새스토리.getStory_title());
	        명령자.setString(2, 새스토리.getStory_contents());
	        명령자.setBytes(3, 새스토리.getStory_profile());
	        명령자.setTimestamp(4, 새스토리.getStory_time());
	        명령자.setInt(5, 새스토리.getWriter().getMember_no());//작성자 회원의 번호를 준다
	        명령자.executeUpdate();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
		
	}

	@Override
	public List<Story> 모든스토리을수집하다() {
		List<Story> 수집된스토리들 = new ArrayList<Story>(); 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("select story_no,story_title,writer,story_views from story");
	        ResultSet 게시물표= 명령자.executeQuery();
	        while(게시물표.next()) {
	        	int no = 게시물표.getInt("story_no");
	        	String title=게시물표.getString("story_title");	        
	        	int 작성한회원의번호 = 게시물표.getInt("writer");	        	
	        	int views = 게시물표.getInt("story_views");
	        	Member 작성한회원 = 회원DAO.찾다By회원번호(작성한회원의번호);
	        	
	        	Story 스토리=new Story();
	        	스토리.setStory_no(no);
	        	스토리.setStory_title(title);
	        	스토리.setWriter(작성한회원);//주목
	        	스토리.setStory_views(views);
	        	
	        	수집된스토리들.add(스토리);
	        }
	    }
		catch(Exception ex){ ex.printStackTrace(); }
		return 수집된스토리들;
	}

	@Override
	public Story 스토리을찾다And조회수증가하다(int 스토리번호) {
		Story 스토리 = null; 
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자2=con.prepareStatement("update story set story_views=story_views+1 where story_no=?");
	        명령자2.setInt(1, 스토리번호);
	        명령자2.executeUpdate();
	        명령자2.close();
	        
	        PreparedStatement 명령자=con.prepareStatement("select story_no,story_title,story_contents,story_profile,story_time,writer,story_views from story where story_no=?");
	        명령자.setInt(1, 스토리번호);
	        ResultSet 게시물표= 명령자.executeQuery();
	        if(게시물표.next()) {
	        	int no = 게시물표.getInt("story_no");
	        	String title=게시물표.getString("story_title");
	        	String contents =게시물표.getString("story_contents");
	        	byte[] profile=게시물표.getBytes("story_profile");
	        	Timestamp time = 게시물표.getTimestamp("story_time");
	        	int 작성한회원의번호 = 게시물표.getInt("writer");	        	
	        	int views = 게시물표.getInt("story_views");
	        	Member 작성한회원 = 회원DAO.찾다By회원번호(작성한회원의번호);
	        	
	        	스토리=new Story();
	           	스토리.setStory_no(no);
	        	스토리.setStory_title(title);
	        	스토리.setStory_contents(contents);
	        	스토리.setStory_profile(profile);
	        	스토리.setStory_time(time);
	        	스토리.setWriter(작성한회원);//주목
	        	스토리.setStory_views(views);
	        }
	    }
		catch(Exception ex){ ex.printStackTrace(); }
		return 스토리;
	}

	@Override
	public void 삭제하다(int 스토리번호) {
		Connection con = null;		 
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
		    
	        PreparedStatement 명령자=con.prepareStatement("delete from story where story_no=?"); 
	        명령자.setInt(1, 스토리번호);
	        명령자.executeUpdate();
	        
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }	
	}

	@Override
	public void 변경하다(Story 변경할스토리) {
		Connection con = null;		 
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
		        
	        PreparedStatement 명령자=con.prepareStatement("update story set story_title=?, story_contents=?, story_time=? where story_no=?"); 
	        명령자.setString(1, 변경할스토리.getStory_title());
	        명령자.setString(2, 변경할스토리.getStory_contents());
	        명령자.setTimestamp(3, 변경할스토리.getStory_time());
	        명령자.setInt(4, 변경할스토리.getWriter().getMember_no());

	        명령자.executeUpdate();
	        
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }	
	}
	
	
}
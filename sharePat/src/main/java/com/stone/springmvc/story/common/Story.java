package com.stone.springmvc.story.common;


import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.stone.springmvc.member.common.Member;

public class Story {
	int story_no;
	String story_title;
	String story_contents;
	int story_views;
	MultipartFile story_profileFile;
	byte [] story_profile;            
	Timestamp story_time;
	Member writer; // 검토
	
	public int getStory_no() {
		return story_no;
	}
	public void setStory_no(int story_no) {
		this.story_no = story_no;
	}
	public String getStory_title() {
		return story_title;
	}
	public void setStory_title(String story_title) {
		this.story_title = story_title;
	}
	public String getStory_contents() {
		return story_contents;
	}
	public void setStory_contents(String story_contents) {
		this.story_contents = story_contents;
	}
	public int getStory_views() {
		return story_views;
	}
	public void setStory_views(int story_views) {
		this.story_views = story_views;
	}
	public MultipartFile getStory_profileFile() {
		return story_profileFile;
	}
	public void setStory_profileFile(MultipartFile story_profileFile) {
		this.story_profileFile = story_profileFile;
	}
	public byte[] getStory_profile() {
		try {
			if(story_profileFile!=null && story_profile==null) {
				//업로드된 파일에서 프로필사진 데이터만 추출
				story_profile = story_profileFile.getBytes();
			}
		}
		catch(Exception ex) {ex.printStackTrace();}
		return story_profile;
	}
	public void setStory_profile(byte[] story_profile) {
		this.story_profile = story_profile;
	}
	public Timestamp getStory_time() {
		return story_time;
	}
	public void setStory_time(Timestamp story_time) {
		this.story_time = story_time;
	}
	public Member getWriter() {
		return writer;
	}
	public void setWriter(Member writer) {
		this.writer = writer;
	}

}

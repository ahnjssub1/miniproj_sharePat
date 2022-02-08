package com.stone.springmvc.shareNote.common;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.stone.springmvc.member.common.Member;

public class ShareNote {
	int share_no;
	String share_title;
	String share_contents;
	MultipartFile share_profileFile;
	byte [] share_profile;            
	Timestamp share_time;
	Member writer; // 검토
	
	public int getShare_no() {
		return share_no;
	}
	public void setShare_no(int share_no) {
		this.share_no = share_no;
	}
	public String getShare_title() {
		return share_title;
	}
	public void setShare_title(String share_title) {
		this.share_title = share_title;
	}
	public String getShare_contents() {
		return share_contents;
	}
	public void setShare_contents(String share_contents) {
		this.share_contents = share_contents;
	}
	public MultipartFile getShare_profileFile() {
		return share_profileFile;
	}
	public void setShare_profileFile(MultipartFile share_profileFile) {
		this.share_profileFile = share_profileFile;
	}
	public byte[] getShare_profile() {
		try {
			if(share_profileFile!=null && share_profile==null) {
				//업로드된 파일에서 프로필사진 데이터만 추출
				share_profile = share_profileFile.getBytes();
			}
		}
		catch(Exception ex) {ex.printStackTrace();}
		return share_profile;
	}
	public void setShare_profile(byte[] share_profile) {
		this.share_profile = share_profile;
	}
	public Timestamp getShare_time() {
		return share_time;
	}
	public void setShare_time(Timestamp share_time) {
		this.share_time = share_time;
	}
	public Member getWriter() {
		return writer;
	}
	public void setWriter(Member writer) {
		this.writer = writer;
	}
	
	
}

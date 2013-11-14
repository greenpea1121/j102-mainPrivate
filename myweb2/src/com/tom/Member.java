package com.tom;

public class Member {
	String userid;
	String nickname;
	String pw;
	String email;
	
	
	public Member(String userid, String nickname, String pw, String email) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.pw = pw;
		this.email = email;
	}

	public Member(){
		
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

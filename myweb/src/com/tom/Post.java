package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Post {
	String userid;
	String nickname;
	String title;
	String content;
	public Post(){
		
	}
	
	public Post(String userid, String nickname, String title, String content) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
	}

	public boolean save(){
		boolean saved = false;
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://j.snpy.org/j102?useUnicode=true&characterEncoding=UTF-8", "jstu", "abc123");
			String sql = "insert into guestbook(userid,nickname,title,content) values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, nickname);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			int rowCount = pstmt.executeUpdate();
			if (rowCount==1){
				saved = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saved;
		
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

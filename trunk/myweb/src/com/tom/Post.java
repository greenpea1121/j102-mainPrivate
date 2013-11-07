package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class Post {
	int id;
	String userid;
	String nickname;
	String title;
	String content;
	ArrayList<Post> allPosts;
	
	public Post(){
		
	}
	
	public Post(int id, String userid, String nickname, String title) {
		super();
		this.id = id;
		this.userid = userid;
		this.nickname = nickname;
		this.title = title;
	}

	public Post(String userid, String nickname, String title, String content) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.title = title;
		this.content = content;
	}

	public int delete(int id){
		int rowCount = 0;
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://j.snpy.org/j102?useUnicode=true&characterEncoding=UTF-8",
					"jstu2", "abc123");
			String sql = "delete from guestbook where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public ArrayList<Post> getAllPosts(){
		if (allPosts==null)
			allPosts = new ArrayList<Post>();
		allPosts.clear();
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://j.snpy.org/j102?useUnicode=true&characterEncoding=UTF-8",
					"jstu", "abc123");
			String sql = "select id,userid,nickname,title from guestbook";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String userid = rs.getString("userid");
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				Post p = new Post(id, userid, nickname, title);
				allPosts.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allPosts;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAllPosts(ArrayList<Post> allPosts) {
		this.allPosts = allPosts;
	}
	
}

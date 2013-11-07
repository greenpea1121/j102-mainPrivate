package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class Member {
	String userid;
	String nickname;
	String pw1;
	String pw2;
	String email;
	private String useridMessage;
	private String pwMessage;
	private String emailMessage;
	private String nicknameMessage;
	private boolean login;

	public Member(String userid, String pw1) {
		super();
		this.userid = userid;
		this.pw1 = pw1;
	}

	public Member(){
		
	}

	public Member(String userid, String nickname, String pw1, String pw2,
			String email) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.pw1 = pw1;
		this.pw2 = pw2;
		this.email = email;
	}

	public Member(String userid, String pw1, String pw2, String email) {
		super();
		this.userid = userid;
		this.pw1 = pw1;
		this.pw2 = pw2;
		this.email = email;
	}

	public boolean login(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		login = false;
		try {
			DriverManager.registerDriver(new Driver());
			conn = DriverManager.getConnection(
				"jdbc:mysql://j.snpy.org/j102", "jstu", "abc123");
			String sql = "select * from users where userid=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, pw1);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				login = true;
				nickname = rs.getString("nickname");
				email = rs.getString("email");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (conn!=null){
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		return login;
	}
	
	public boolean validate(){
		boolean valid = true;
		if (userid.length()<4 || userid.length()>20){
			valid = false;
			useridMessage = "使用者帳號長度不符合";
		}
		if (nickname.length()<6 || nickname.length()>20){
			valid = false;
			nicknameMessage = "暱稱長度不符合";
		}
		if (!pw1.equals(pw2)){
			valid = false;
			pwMessage = "密碼不符合";
		}
		if (email.indexOf("@")==-1){
			valid = false;
			emailMessage = "電子郵件格式錯誤";
		}
		if (valid){
//			saveOld();
			try {
				DriverManager.registerDriver(new Driver());
				Connection conn = DriverManager.getConnection(
					"jdbc:mysql://j.snpy.org/j102", "jstu", "abc123");
				String sql = "INSERT INTO users(id, nickname, password, email) values(?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2, nickname);
				pstmt.setString(3, pw1);
				pstmt.setString(4, email);
				int rowCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return valid;
	}

	private void saveOld() {
		//1
		try {
			DriverManager.registerDriver(new Driver());
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://j.snpy.org/j102", "jstu", "abc123");
			Statement stmt = conn.createStatement();
			String sql = "Insert into users(id, nickname, password, email) values ('"+userid+"','"+nickname+"','"+pw1+"','"+email+"')";
			System.out.println(sql);
			int rowCount = stmt.executeUpdate(sql);
			System.out.println(rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUseridMessage() {
		return useridMessage;
	}

	public void setUseridMessage(String useridMessage) {
		this.useridMessage = useridMessage;
	}

	public String getPwMessage() {
		return pwMessage;
	}

	public void setPwMessage(String pwMessage) {
		this.pwMessage = pwMessage;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNicknameMessage() {
		return nicknameMessage;
	}

	public void setNicknameMessage(String nicknameMessage) {
		this.nicknameMessage = nicknameMessage;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	
	
}

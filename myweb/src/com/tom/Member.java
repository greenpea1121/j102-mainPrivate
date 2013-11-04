package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Member {
	String userid;
	String pw1;
	String pw2;
	String email;
	private String useridMessage;
	private String pwMessage;
	private String emailMessage;
	
	public Member(){
		
	}

	public Member(String userid, String pw1, String pw2, String email) {
		super();
		this.userid = userid;
		this.pw1 = pw1;
		this.pw2 = pw2;
		this.email = email;
	}

	public boolean validate(){
		boolean valid = true;
		if (userid.length()<4 || userid.length()>20){
			valid = false;
			useridMessage = "使用者帳號長度不符合";
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
			//1
			try {
				DriverManager.registerDriver(new Driver());
				//Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
					"jdbc:mysql://j.snpy.org/j102", "jstu", "abc123");
				Statement stmt = conn.createStatement();
				String sql = "Insert into users(id, password, email) values ('"+userid+"','"+pw1+"','"+email+"')";
				System.out.println(sql);
				int rowCount = stmt.executeUpdate(sql);
				System.out.println(rowCount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valid;
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
	
	
}

package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class MemberDAO {
	public static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				DriverManager.registerDriver(new Driver());
				conn = DriverManager.getConnection(
						"jdbc:mysql://j.snpy.org/j102", "jstu2", "abc123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;

	}

	public List<Member> getAll() {
		List<Member> members = new ArrayList<Member>();
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while (rs.next()) {
				String userid = rs.getString("id");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("password");
				String email = rs.getString("email");
				Member member = new Member(userid, nickname, pw, email);
				members.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}

	public int delete(String userid) {
		String sql = "delete from users where id=?";
		int rowCount = 0;
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, userid);
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int add(Member m){
		String sql = "insert into users(id,nickname,password,email) values (?,?,?,?)";
		int rowCount = 0;
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, m.getUserid());
			pstmt.setString(2, m.getNickname());
			pstmt.setString(3, m.getPw());
			pstmt.setString(4, m.getEmail());
			rowCount = pstmt.executeUpdate();
			System.out.println(rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int update(Member m){
		String sql = "update users set(nickname=?,pw=?,email=?) where id=?";
		int rowCount = 0;
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, m.getNickname());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getUserid());
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}

	
	public static void main(String[] args){
//		testgetAll();
		MemberDAO dao = new MemberDAO();
		System.out.println(dao.delete("aa123"));
	}

	private static void testgetAll() {
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.getAll();
		System.out.println(list.size());
	}
	
}

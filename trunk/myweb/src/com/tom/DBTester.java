package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DBTester {

	public static void main(String[] args) {
		// insert();
		// query();
//		update();
//		delete();
	}

	private static void delete() {
		try {
			DriverManager.registerDriver(new Driver());
			// Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://j.snpy.org/j102", "jstu2", "abc123");
			String sql = "delete from guestbook where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 25);
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void update() {
		try {
			DriverManager.registerDriver(new Driver());
			// Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://j.snpy.org/j102", "jstu2", "abc123");
			String sql = "update guestbook set userid=?, nickname=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Tom");
			pstmt.setString(2, "Hank");
			pstmt.setInt(3, 25);
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void query() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new Driver());
			// Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://j.snpy.org/j102",
					"jstu", "abc123");
			String sql = "select * from users";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String userid = rs.getString("id");
				String nickname = rs.getString("nickname");
				String pw = rs.getString("password");
				String email = rs.getString("email");
				System.out.println(userid + "/" + nickname + "/" + pw + "/"
						+ email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && pstmt != null) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void insert() {
		// 1
		try {
			DriverManager.registerDriver(new Driver());
			// Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://j.snpy.org/j102", "jstu", "abc123");
			Statement stmt = conn.createStatement();
			int rowCount = stmt
					.executeUpdate("INSERT INTO users(id, password, email) values ('stu40', '123', 'tom@com.tw')");
			System.out.println(rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

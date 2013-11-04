package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DBTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1
		try {
			DriverManager.registerDriver(new Driver());
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://j.snpy.org/j102", "jstu", "abc123");
			Statement stmt = conn.createStatement();
			int rowCount = stmt.executeUpdate("INSERT INTO users(id, password, email) values ('stu40', '123', 'tom@com.tw')");
			System.out.println(rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class User {
	public User(){
		
	}
	
	public String hello(){
		return "Hello";
	}
	
	public String hello(String name){
		return "HELLO, "+name;
	}
	
	public String[] getCity(){
		return new String[]{"台北市","新北市", "基隆市", "高雄市"};
	}
	
	public String[] getArea(String city){
		ArrayList<String> areas = new ArrayList<String>();
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://j.snpy.org/j102?useUnicode=true&characterEncoding=UTF-8", "jstu", "abc123");
			String sql = "select Area, ZipCode from zipcode where City=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				areas.add(rs.getString("Area"));
				System.out.println(rs.getString("Area"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areas.toArray(new String[areas.size()]);
	}
}





















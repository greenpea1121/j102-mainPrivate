<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言清單</title>
</head>
<body>
<%
DriverManager.registerDriver(new Driver());
Connection conn = DriverManager.getConnection("jdbc:mysql://j.snpy.org/j102",
		"jstu", "abc123");
String sql = "select userid,nickname,title from guestbook";
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
	String userid = rs.getString("userid");
	String nickname = rs.getString("nickname");
	String title = rs.getString("title");
	
	
	out.println("</br>");
}

%>


</body>
</html>
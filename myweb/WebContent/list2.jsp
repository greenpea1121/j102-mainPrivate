<%@page import="com.tom.Post"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="p" class="com.tom.Post" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
for (Post post: p.getAllPosts()){
	%>
	<TR>
		<TD><%=post.getId() %></TD>
		<TD><%=post.getUserid() %></TD>
		<TD><%=post.getNickname() %></TD>
		<TD><%=post.getTitle() %></TD>
		<TD><a href="delete_post.jsp?id=<%=post.getId() %>">刪除</a></TD>
	</TR>
	<%
}
%>
</table>

</body>
</html>
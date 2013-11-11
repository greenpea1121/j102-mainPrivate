<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="com.tom.Member" scope="session"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首頁</title>
</head>
<body>
	這是首頁
	<%
	if (m.isLogin()){
	%>
		<a href="logout.jsp">登出</a>
	<%	
	}else{
	%>
	<a href="login.jsp">登入</a>
	<%
	}
	%>
	
	</br>
	<ul>
		<li><a href="add_post.jsp">新增留言(add_post.jsp)</a></li>
		<li><a href="list2.jsp">留言清單(list2.jsp)</a></li>
	</ul>
</body>
</html>
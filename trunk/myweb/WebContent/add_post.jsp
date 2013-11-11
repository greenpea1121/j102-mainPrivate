<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="p" class="com.tom.Post" scope="session"></jsp:useBean>
<jsp:useBean id="m" class="com.tom.Member" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userid="";
String nickname="";
if (!m.isLogin()){
%>
  您目前尚未登入,可按<a href="login.jsp">此登入</a>	
<%
}else{
	userid = m.getUserid();
	nickname = m.getNickname();
}
%>

<form action="addpost" method="post">
userid<input type="text" name="userid" value="<%=userid %>"/>
</br>
nickname<input type="text" name="nickname" value="<%=nickname %>"/>
</br>
title<input type="text" name="title" value=""/>
</br>
content<input type="text" name="content" value=""/>
</br>
<input type="submit" value="送出" />
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.tom.Member" scope="session"></jsp:useBean>
<%
if (member.isLogin()){
	response.sendRedirect("index.jsp");
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="POST">
帳號:<input type="text" name="userid" value="${member.userid }" />
</br>
密碼:<input type="text" name="pw" value="${member.pw1 }"/>
</br>
${member.loginMessage }
<input type="submit" value="登入" />
</form>
</body>
</html>
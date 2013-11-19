<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String userid = request.getParameter("userid");
userid = new String(userid.getBytes(), "ISO-8859-1");
System.out.println(userid);
%>

<form action="">
<input type="text" name="userid" />
<input type="submit" />
</form>
</body>
</html>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="reg">
	  帳號:<input id="userid" name="userid" type="text" value=""/>
	<br/>
	  密碼:<input id="pw1" name="pw1" type="text" value=""/> 
	<br/>
	  密碼:<input id="pw2" name="pw2" type="text" value=""/>
	<br/>
	  E-mail:<input name="email" type="text" value=""/>
	<br/>
	  <input type="submit" value="註冊"/>
</form>

</body>
</html>










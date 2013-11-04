<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
public int max(int a , int b){
	return (a>b)? a : b;
}


%>


<%
Random r = new Random();
int number = r.nextInt(6)+1;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if (number %2 == 0){
%>
<font color='#ff0000'>
<%
}
%>
<%=number %>
<%
if (number %2 == 0){
%>
</font>
<%
}
%>
</body>
</html>
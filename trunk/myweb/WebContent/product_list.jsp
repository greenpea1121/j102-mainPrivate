<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="prod" class="com.tom.Product" scope="session"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<c:forEach items="${prod.products }" var="p">
<TR>
  <td>${p.id }</td>
  <td>${p.name }</td>
  <td>${p.price }</td>
</TR>
</c:forEach>
</table>
</body>
</html>
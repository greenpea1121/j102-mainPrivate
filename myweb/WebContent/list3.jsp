<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="p" class="com.tom.Post" scope="session"></jsp:useBean>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
request.setAttribute("posts", p.getAllPosts());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<display:table name="posts" >
  <display:column property="id" title="ID" />
  <display:column property="userid" />
  <display:column property="nickname" />
  <display:column property="title" />
</display:table>
</body>
</html>
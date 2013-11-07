<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="p" class="com.tom.Post" scope="session"></jsp:useBean>

<%
int rowCount = 0;
String s = request.getParameter("id");
if (s!=null){
	rowCount = p.delete(Integer.parseInt(s));
}
%>
<%=rowCount %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if (rowCount>0) {%>
已成功刪除
<%} %>

<a href="list2.jsp">回留言清單</a>
</body>
</html>
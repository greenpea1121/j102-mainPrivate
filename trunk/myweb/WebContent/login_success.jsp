<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="com.tom.Member" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login_success</title>
</head>
<body>
${m.nickname },您好,登入成功 
<%
//String referer = (String)session.getAttribute("login_referer");
//if (referer!=null && !referer.substring(referer.lastIndexOf("/")).equals("/index.jsp")){
if (m.getReferer()!=null){
	%>
	<a href="${m.referer }">回到上一個功能</a>	
	<%
	m.setReferer(null);
	//session.removeAttribute("login_referer");
}
%>
<a href="index.jsp">到首頁</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member.jsp</title>
</head>
<body>
<form action="MemberController" method="POST">
	<input type="hidden" name="action" value="edit" />
	帳號: <input type="text" name="userid" value="${m.userid }"/></br> 
	暱稱: <input type="text" name="nickname" value="${m.nickname }"/></br> 
	密碼: <input type="text" name="pw" value="${m.pw }"/> </br>
	E-mail: <input type="text" name="email" value="${m.email }"/> </br>
<input type="submit" value="送出" />
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member.jsp</title>
</head>
<body>
<form action="MemberController">
	<input type="hidden" name="action" value="addMember" />
	帳號: <input type="text" name="userid" value=""/></br> 
	暱稱: <input type="text" name="nickname" value=""/></br> 
	密碼: <input type="text" name="pw" value=""/> </br>
	E-mail: <input type="text" name="email" value=""/> </br>
<input type="submit" value="送出" />
</form>
</body>
</html>
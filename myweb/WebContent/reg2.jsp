<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="com.tom.Member" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="reg">
	  帳號:<input id="userid" name="userid" type="text" value="${m.userid }"/> ${m.useridMessage }
	<br/>
	 暱稱:<input id="nickname" name="nickname" type="text" value="${m.nickname }"/> ${m.nicknameMessage }
	<br/>
	
	  密碼:<input id="pw1" name="pw1" type="text" value="${m.pw1 }"/>  ${m.pwMessage }
	<br/>
	  密碼:<input id="pw2" name="pw2" type="text" value="${m.pw2 }"/>
	<br/>
	  E-mail:<input name="email" type="text" value="${m.email }"/> ${m.emailMessage }
	<br/>
	  <input type="submit" value="註冊"/>
</form>

</body>
</html>










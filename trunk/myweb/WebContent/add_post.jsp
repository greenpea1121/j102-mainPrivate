<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="p" class="com.tom.Post" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addpost" method="post">
<input type="text" name="userid" value=""/>
</br>
<input type="text" name="nickname" value=""/>
</br>
<input type="text" name="title" value=""/>
</br>
<input type="text" name="content" value=""/>
</br>
<input type="submit" value="送出" />
</form>
</body>
</html>
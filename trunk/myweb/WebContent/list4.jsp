<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/j102">
	<c:choose>
		<c:when test="${empty param.userid }">
			select * from guestbook
		</c:when>
		<c:otherwise>
			select * from guestbook where userid=?
			<sql:param>${param.userid }</sql:param>
		</c:otherwise>
	</c:choose>
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
 <input type="text" name="userid" />
 <input type="submit" value="搜尋" />
</form>
Total: ${rs.rowCount }
<table border="1">
	<c:forEach var="p" items="${rs.rows }">
	<TR>
		<TD>${p.id }</TD>
		<TD>${p.userid }</TD>
		<TD>${p.nickname }</TD>
		<TD>${p.title }</TD>
		<TD></TD>
		<TD><a href="delete_post.jsp?id=">刪除</a></TD>
	</TR>
	</c:forEach>
</table>

</body>
</html>
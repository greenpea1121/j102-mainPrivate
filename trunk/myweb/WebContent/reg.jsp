<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
String useridMessage = null;
String pwMessage = null;
String emailMessage = null;
String userid = null;
String pw1 = null;
String pw2 = null;
String email = null;
if (request.getParameter("userid")!=null){
	userid = request.getParameter("userid");
	pw1 = request.getParameter("pw1");
	pw2 = request.getParameter("pw2");
	email = request.getParameter("email");
	boolean valid = true;
	if (userid.length()<4 || userid.length()>20){
		valid = false;
		useridMessage = "使用者帳號長度不符合";
	}
	if (!pw1.equals(pw2)){
		valid = false;
		pwMessage = "密碼不符合";
	}
	if (email.indexOf("@")==-1){
		valid = false;
		emailMessage = "電子郵件格式錯誤";
	}
	if (valid){
		//1
		DriverManager.registerDriver(new Driver());
		//Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://j.snpy.org/j102", "jstu", "abc123");
		Statement stmt = conn.createStatement();
		String sql = "Insert into users(id, password, email) values ('"+userid+"','"+pw1+"','"+email+"')";
		System.out.println(sql);
		int rowCount = stmt.executeUpdate(sql);
		System.out.println(rowCount);
	}
}
%>
<body>

<form action="">
	  帳號:<input id="userid" name="userid" type="text" value="<%=userid==null? "": userid%>"/><%=useridMessage==null? "": useridMessage %>
	<br/>
	  密碼:<input id="pw1" name="pw1" type="text" value="<%=pw1==null? "":pw1%>"/> <%=pwMessage==null? "": pwMessage %>
	<br/>
	  密碼:<input id="pw2" name="pw2" type="text" value="<%=pw2==null? "":pw2%>"/>
	<br/>
	  E-mail:<input name="email" type="text" value="<%=email==null ?"":email%>"/><%=emailMessage==null? "": emailMessage %>
	<br/>
	  <input type="submit" value="註冊"/>
</form>

</body>
</html>










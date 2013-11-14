<%@page import="com.tom.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cart" class="com.tom.Cart" scope="session"></jsp:useBean>
<jsp:useBean id="prod" class="com.tom.Product" scope="session"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<c:set target="${prod }" property="id" value="${param.id }"></c:set>
<%
int qty = Integer.parseInt(request.getParameter("q"));
Item item = new Item(prod.getId(), prod.getPrice(), qty);
cart.getItems().add(item);
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
想放入購物車的品項:
${prod.id }, ${prod.name }, ${prod.price }, ${param.q }, ${prod.price*param.q }

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="prod" class="com.tom.Product" scope="session"></jsp:useBean>
<jsp:useBean id="cart" class="com.tom.Cart" scope="session"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set target="${prod }" property="id" value="${param.id }"></c:set>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<a href="cart.jsp">購物車</a>(${cart.total})<%=cart.getItems().size() %>
</p>

		<table border="1" cellpadding="1" cellspacing="1" style="width: 600px;">
			<tbody>
				<tr>
					<td colspan="2">
						${prod.name }</td>
				</tr>
				<tr>
					<td colspan="1" rowspan="2">
						<img src="images/${prod.pic }"/ ></td>
					<td>
						${prod.desc }</td>
				</tr>
				<tr>
					<td>
						${prod.price }
						<form action="add_cart.jsp">
							<input type="hidden" name="id" value="${prod.id }" />
							數量:<input type="text" name="q" value="1"/>
							<input type="submit" value="加入購物車"/>
						</form>
						</td>
				</tr>
			</tbody>
		</table>
<p><a href="product_list.jsp">回產品清單</a></p>
</body>
</html>




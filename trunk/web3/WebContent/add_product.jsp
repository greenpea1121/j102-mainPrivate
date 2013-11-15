<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="addProduct" enctype="multipart/form-data" >
名稱:<input type="text" name="name" value="" /></br>
說明:<input type="text" name="desc" value="" /></br>
售價:<input type="text" name="price" value="100" /></br>
庫存:<input type="text" name="stock" value="0" /></br>
圖檔:<input type="file" name="pic" /> <br/>
  <input type="submit" value="送出" name="upload" id="upload" />
</form>
</body>
</html>
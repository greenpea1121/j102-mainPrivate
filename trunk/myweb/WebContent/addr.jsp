<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='/myweb/dwr/interface/User.js'></script>
<script type='text/javascript' src='/myweb/dwr/engine.js'></script>
<script type='text/javascript' src='/myweb/dwr/util.js'></script>
<script type="text/javascript" src="jquery-1.10.2.js"></script>
<script type="text/javascript">
$().ready(function(){
	User.getCity(fillCity);
	$("#city").change(function(e){
		var city = this.value;
		//alert(city);
		User.getArea(city, fillArea);
	});
	
	function fillCity(list){
		DWRUtil.removeAllOptions("city");
	    DWRUtil.addOptions("city", list);
	}
	function fillArea(list){
		DWRUtil.removeAllOptions("area");
	    DWRUtil.addOptions("area", list);
	}
});

/*
$(document).ready(function(){
	$("#city").change(function(e){
		//alert(this.value);
		var city = this.value;
		$.ajax({
			url: "getArea?city="+city ,	
			cache: false ,
			dataType: "json" , 
			success: function (json) {
				
			}	
		})
	});
});
*/

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<select id="city">
</select>
<select id="area">
</select>
</body>
</html>
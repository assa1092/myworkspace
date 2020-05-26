<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ms2" method = "post">
		ID  : <input name = "id"><br>
		PW  : <input name = "pw"><br>
		<input type = "submit" value = "로그인">
		<!-- 서버로 보내려고 하면 name 값을 주어야한다.  -->
	</form>
	<hr>
	<form action="ms2" method = "get">
		name : <input name = "name"><br>
		age  : <input name = "age"><br>
		<input type = "submit">
	</form>

</body>
</html>
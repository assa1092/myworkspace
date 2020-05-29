<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 화면</h1>
	<form action="insert.bo" method="post">
		ID : <input name="id"><br>
		Name : <input name="name"><br>
		Age : <input name="age" type="number"><br>
		PW :  <input name="pw" type="password"><br>
		
		<input type="submit" value="가입">
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<!-- insert 서브릿으로 이동. 확장자형의 url-pattern 으로 -->
	<form action="insert.do" method = "post">
		ID : <input name = "id"><br>
		Name : <input name = "name"><br>
		Age : <input type ="number" name = "age"><br>
		
		<input type = "submit" value = "가입">
		
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정.</h1>
	<form action="memberupdate.do" method="post">
		ID : <input name="id" value="${dto.id}" readonly><br>
		Name : <input name= "name" value="${dto.name }"><br>
		Pw : <input name ="pw" type ="password" required><br>
		<input type = "submit" value = "수정">
	</form>

</body>
</html>
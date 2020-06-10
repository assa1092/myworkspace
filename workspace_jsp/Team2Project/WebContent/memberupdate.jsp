<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 수정</h2>
	<form action="memberupdate.do" method="post">
		ID: <input name="id" value="${mDTO.id}" readonly><br>
		이름: <input name="name" value="${mDTO.name}"><br>
		PW: <input name="pw" type="password" required><br>
		<input type="submit" value="수정">
	
	</form>

</body>
</html>
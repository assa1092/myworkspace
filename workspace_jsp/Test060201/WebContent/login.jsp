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

	<form action="NewFile8.jsp" method="post">
		<!--  LoginBean 에 작성된 변수이름과 똑같아야한다... -->
		ID : <input name="id"><br>
		PW : <input name="pw"><br>
			<input type="submit" value="로그인">
	
	</form>

</body>
</html>
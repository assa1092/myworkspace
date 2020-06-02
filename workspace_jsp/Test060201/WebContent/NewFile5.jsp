<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- useBean 객체 만듬...id로 변수명을... class 로 경로를 -->
<jsp:useBean id="login" class="com.naver.LoginBean"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		login.setId("m002");
		login.setPw("1");
		
		// EL이 인식하도록 데이터 바인딩...
		pageContext.setAttribute("login", login);
	%>
	<%= login.getId() %> : <%= login.getPw() %>
	<hr>
	${login.id } : ${login.pw }
</body>
</html>
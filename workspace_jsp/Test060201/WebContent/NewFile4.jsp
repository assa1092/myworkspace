<%@page import="com.naver.LoginBean"%>
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
	
	<%
		LoginBean login = new LoginBean();
		login.setId("m001");
		login.setPw("1");
		
		// EL이 인식하도록 데이터 바인딩...
		pageContext.setAttribute("login", login);
	
	%>
	<%= login.getId() %>
	<%= login.getPw() %>
	<%-- 바인딩된 데이터는 EL이 인식함... --%>
	${login.id}
	${login.pw}
	
	
</body>
</html>
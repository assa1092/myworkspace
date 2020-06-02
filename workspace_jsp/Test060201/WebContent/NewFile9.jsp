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
<!-- 내장객체는 스트릿틀릿 안에서만 쓸수있다... -->
	<% 
		String id = request.getParameter("id");
		out.print(id);
		
		// 데이터 바인딩
		request.setAttribute("id", id);
		
		id = (String) request.getAttribute("id");
	%>
	
	${id }

	<%
		request.getRequestDispatcher("NewFile8.jsp").forward(request, response);
	%>
	

</body>
</html>
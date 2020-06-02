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

    <!-- pageContext 로 바인딩 되어서 해당페이지가 아니라 여기서는 안됨 -->
    ${p }<br>
    
	${r }<br>
	${s }<br>
	${a }<br>
	
	<%
		response.sendRedirect("NewFile4.jsp");
	%>

</body>
</html>
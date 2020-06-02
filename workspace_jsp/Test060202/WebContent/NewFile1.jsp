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
	<!-- EL 에서는 null 에 대해 관대하다...그래서 어렵다... -->
	<%
		pageContext.setAttribute("m", null);
	%>
	${dto }<br>
	${m }<br>
	<hr>
	${m.id }<br>
	<hr>
	
	${empty m }<br>
	${m == null }<br>
	<hr>
	${not empty m }<br>
	${m != null }<br>

</body>
</html>
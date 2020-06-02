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
		int a=10;
	
		out.print(a);
		
		// EL 에서 쓰기위해 바인딩...
		pageContext.setAttribute("b", a);
	%>
	
	<%= a %>
	<!-- 스크릿틀릿에 선언된 변수는 EL에서 사용못함...  -->
	${a }

</body>
</html>
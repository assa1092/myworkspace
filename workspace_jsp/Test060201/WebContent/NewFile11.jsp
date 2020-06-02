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
	<%!
		int count = 0;
	%>
	
	<%
		// 방문자 수 조회는 보통 FrontController에 작성한다..
		count++;
		// 데이터 바인딩...
		application.setAttribute("count", count);
		
	%>
	
	<label>방문자수: </label>${count}
	
</body>
</html>
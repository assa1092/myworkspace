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
	<!-- 1부터 10까지 찍힌다. -->
	<c:forEach begin="1" end="10" var="num" step="2">
		<a href="select.bo?page=${num}">${num} |</a>
		
	</c:forEach>
	
	<hr>
	
	<!-- status.index 와. status.count를 많이 사용 -->
	<c:forEach begin="200" end="210" var = "num" varStatus="status">
		${status.current } : ${num } : ${status.index } : ${status.count }<br>
	</c:forEach>
	

</body>
</html>
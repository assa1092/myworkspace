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
	<!-- test="요기에 조건을 작성"... -->
	<c:if test="${3 < 4 }">	
		3은 4보다 작다.<br>
	</c:if>
	
	
	<!-- if/else 처럼 하려면 if하나더 사용... -->
	<c:if test="${empty m }">
		m은 null입니다..
	</c:if>
	<c:if test="${not empty m }">
		m은 null이 아닙니다.
	</c:if>
	<hr>
	
	<!-- switch/case 구문과 비슷 -->
	<!-- 값이 없으니 주소창에 ?age=9  이렇게 입력 띄어쓰기하면 안됨-->
	<!-- http://localhost:8089/Test060301/NewFile4.jsp?age=9-->
	<c:choose>
		<c:when test="${param.age>10 }">
			나이가 10보다 큽니다.
		</c:when>
		<c:when test="${param.age > 8}">
			나이가 8보다 큽니다.
		</c:when>
		<c:when test="${param.age>6 }">
			나이가 6보다 큽니다.
		</c:when>
		<c:otherwise>
			해당되는 나이가 없습니다..
		</c:otherwise>
		
	</c:choose>

</body>
</html>
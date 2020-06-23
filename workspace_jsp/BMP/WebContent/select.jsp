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

	<c:if test="${empty login}">
		<a href="memberloginui.do"> 로그인</a>
	</c:if>
	<c:if test="${not empty login }">
		<a href ="memberlogout.do"> 로그아웃</a>
	</c:if>
	
	<a href="memberinsertui.do">회원 가입</a>
	<h1>회원 목록 보기</h1>
	<c:if test="${not empty login }">
		${login.id} 님이 로그인 하였습니다.<br>
	</c:if>
	<c:forEach items="${list}" var ="dto">
		<a href="selectById.do?id=${dto.id}">${dto.id} : ${dto.name}</a><br>
	</c:forEach>

</body>
</html>
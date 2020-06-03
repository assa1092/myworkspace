<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty login}">
		<a href="loginui.bo">c:if 로그인</a>
	</c:if>
	<c:if test="${not empty login }">
		<a href ="logout.bo">c:if 로그아웃</a>
	</c:if>
	
	<c:choose>
		<c:when test="${empty login }">
			<a href="loginui.bo">c:choose 로그인</a>
		</c:when>
		<c:otherwise>
			<a href = "loginout.bo">c:choose 로그아웃</a>
		</c:otherwise>	
	</c:choose>
	
	
	<a href="${empty login? 'loginui.bo' : 'logout.bo' }">${empty login? '로그인' : '로그아웃' }</a>
	<a href = "insertui.bo">회원 가입</a>
	<h1>회원 목록</h1>

	
	<!-- JSTL  향상된 for 문을 얘기함...forEach  -->
	<!-- for(int x : arr)    arr->items="${list}"  int x -> var ="dto" -->
	<c:forEach items="${list}" var="dto">
		<a href="selectById.bo?id=${dto.id }">${dto.id } : ${dto.name }</a>
		<br>
	
	</c:forEach>
	

</body>
</html>
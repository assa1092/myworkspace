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
	<h1>회원 자세히 보기</h1>
	ID : ${dto.id} <br>
	Name : ${dto.name} <br>
	Property : ${dto.property} <br>
	<a href="updateui.do?id=${dto.id}">수 정</a>|<a href="delete.do?id=${dto.id }">삭제</a> | <a href="select.do">목록</a>  

</body>
</html>
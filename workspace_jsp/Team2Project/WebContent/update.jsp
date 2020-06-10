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
</head>
<body>
	<h1>리뷰 수정</h1>
	<form action="update.do" method="post">
		Num    : <input name="num" readonly value="${dto.num }"><br>
		제  목 : <input name="title" value="${dto.title}"><br>
		아이디 : <input name="id" readonly value="${dto.id}"><br> 
		Category : <input name="category" value="${dto.category}"><br>
		별  점 : <input name="starpoint" value="${dto.starpoint}"><br>   
		내  용 : <br>
		<textarea rows="5" name="content">${dto.content}</textarea>
		<input type="submit" value="등록">
	</form>

</body>
</html>
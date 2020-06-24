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
	<h1>글 쓰 기</h1>
	<form action="boardinsert.do" method="post">
		작성자 : <input name="writer"><br>
		제  목 : <input name = "title"><br>
		내  용 : 
		<textarea rows="5" name="content"></textarea>
		<input type="submit" value="글쓰기">
	</form>

</body>
</html>
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
	<h1>글쓰기</h1>
	
	<form action="insert.do" method="post">
		작성자 : <input name = "writer"><br>
		제  목 : <input name = "title"><br>
		내  용 : <br>
		<textarea rows="5" name="content"></textarea><br>
		<input type="submit" value="클릭">
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT 제품 리뷰</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="reviewinsert.do" method="post">

		작성자 : <input name="id" readonly value="${login.id}"><br>
		제목 : <input name="title"><br>
		별점 : <select name="starpoint">
				
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select><br> 
		카테고리 :		
			<select name="category">
				
				<option value="컴퓨터">컴퓨터</option>
				<option value="디지털">디지털</option>
				<option value="가전">가전</option>
			</select>
		
		<br> 내용 : <br>
		<textarea rows="5" name="content"></textarea>
		<br> <input type="submit" value="등록">
	</form>
</body>
</html>
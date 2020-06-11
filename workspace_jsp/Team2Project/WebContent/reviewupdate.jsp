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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<h1>리뷰 수정</h1>
	<form action="reviewupdate.do" method="post">
		Num : <input name="num" readonly value="${dto.num }"><br>
		제 목 : <input name="title" value="${dto.title}"><br>
		 아이디 :<input name="id" readonly value="${dto.id}"><br>
		  별 점 : <select name="starpoint">
				
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
		  Category :<select name="category">
				
				<option value="컴퓨터">컴퓨터</option>
				<option value="디지털">디지털</option>
				<option value="가전">가전</option>
			</select><br>
		
		 내	용 : <br>
		<textarea rows="5" name="content">${dto.content}</textarea>
		<input type="submit" value="등록">
	</form>

</body>
</html>
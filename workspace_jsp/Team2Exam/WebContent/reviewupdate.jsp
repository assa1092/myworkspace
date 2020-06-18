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
	<h1>리뷰 수정</h1>
	<form action="reviewupdate.do?num=${dto.num}" method="post">
		
		작성자 : <input name = "id"  readonly>${dto.id}<br>
		제  목 : <input name = "title" >${dto.title}<br>
		
		<select name="category"	class="form-control" id="category">
		<!-- 기존 입력 값을 받아와서 출력, hidden 속성을 주어 실제로 출력되지 않게 함 -->
			<option value="${dto.category }" hidden>${dto.category }</option>
			<option value="컴퓨터">컴퓨터</option>
			<option value="디지털">디지털</option>
			<option value="가전">가전</option>
		</select>
		
		
		내  용 : <br>
		<!-- </textarea>줄 바꿔놓으면 안된다. -->
		<textarea rows="5" name="content">${dto.content}</textarea><br>	
		별  점 : <br>
		<select name="starpoint" class="form-control" id="starpoint">
			<!-- 기존 입력 값을 받아와서 출력, hidden 속성을 주어 실제로 출력되지 않게 함 -->
			<option value="${dto.starpoint }" hidden>${dto.starpoint }</option>
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
		<input type="submit" value="수정">
		
	</form>

</body>
</html>
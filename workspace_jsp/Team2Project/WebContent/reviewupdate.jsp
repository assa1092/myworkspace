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
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="padding: 20px 70px 0px 70px;">
		<jsp:include page="header.jsp" />
		<h1>리뷰 수정</h1>
		<form action="reviewupdate.do?num=${dto.num }" method="post"
			enctype="multipart/form-data">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="id">작성자</label> <input name="id" type="text"
						class="form-control" id="id" value="${login.id}" readonly>
				</div>

				<div class="form-group col-md-6">
					<label for="category">카테고리</label> <select name="category"
						class="form-control" id="category">
						<!-- 기존 입력 값을 받아와서 출력, hidden 속성을 주어 실제로 출력되지 않게 함 -->
						<option value="${dto.category }" hidden>${dto.category }</option>
						<option value="컴퓨터">컴퓨터</option>
						<option value="디지털">디지털</option>
						<option value="가전">가전</option>
					</select><br>
				</div>
			</div>
			<div class="form-group">
				<label for="title">제목</label> 
				<input name="title" type="text"	class="form-control" id="title" placeholder="제목을 입력하세요."required="required" value = '${dto.title }'>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea rows="10" name="content" class="form-control" id="content"
					placeholder="내용을 입력하세요.">${dto.content }</textarea>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="starpoint">별점</label> <select name="starpoint"
						class="form-control" id="starpoint">
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
				</div>	

			</div>
			<div class="form-group"></div>
			<div class="form-group">
				<label for="file">첨부파일</label> <input type="file" name="file"
					class="form-control" id="file" placeholder = '${udto.fileName }'>
					현재 업로드된 파일 : ${udto.fileName }
				</textarea>
			</div>

			<button type="submit" class="btn btn-primary">수정</button>
		</form>
		<br> <br> <br>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
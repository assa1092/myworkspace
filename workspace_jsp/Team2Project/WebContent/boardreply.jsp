<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>IT 제품 리뷰</title>
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
	<div style="padding: 20px 70px 0px 70px;">
		<jsp:include page="header.jsp" />
		<h1>댓글쓰기</h1>

		<form action="boardreply.do?" method="post"
			enctype="multipart/form-data">
			
			<!-- 부모글의 num을 가져가야하기때문에... num 값을 유지시키는중... -->
			<input type ="hidden" name = "num" value ="${param.num}">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="writer">작성자</label> <input name="writer" type="text"
						class="form-control" id="writer" value="${login.id}">
				</div>	
			</div>
			
			<div class="form-group">
				<label for="title">제목</label> <input name="title" type="text"
					class="form-control" id="title" placeholder="제목을 입력하세요."
					required="required">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea rows="10" name="content" class="form-control" id="content"
					placeholder="내용을 입력하세요."></textarea>
			</div>
		
			<div class="form-group"></div>
			<div class="form-group">
				<label for="file">첨부파일</label> <input type="file" name="file"
					class="form-control" id="file">
			</div>

			<button type="submit" class="btn btn-primary">댓글쓰기</button>
		</form>
		<br>
		<br>
		<br>

		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>
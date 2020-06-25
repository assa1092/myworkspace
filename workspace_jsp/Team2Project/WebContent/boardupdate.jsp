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
</head>
<body>
	<div style="padding: 20px 70px 0px 70px;">
		<jsp:include page="header.jsp" />
		<h1>댓글 수정</h1>
		<form action="boardupdate.do?num=${dto.num }" method="post"
			enctype="multipart/form-data">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="id">작성자</label> <input name="writer" type="text"
						class="form-control" id="writer" value="${login.id}" readonly>
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
			
			<div class="form-group"></div>
			<div class="form-group">
				<label for="file">첨부파일</label> <input type="file" name="file"
					class="form-control" id="file" placeholder = '${udto.fileName }'>
					현재 업로드된 파일 : ${udto.fileName }
				
			</div>

			<button type="submit" class="btn btn-primary">수정</button>
		</form>
		<br> <br> <br>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
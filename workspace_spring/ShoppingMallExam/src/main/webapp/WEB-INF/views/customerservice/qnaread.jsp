<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" flush="false" />
	<div class="container">
		<div class="row text-center">
			<h1>글 자세히 보기</h1>
		</div>
		<div class="row">
			<div class="form-group">
				<label for="qnaTitle">제목</label> <input readonly
					value="${qdto.qnaTitle}" class="form-control">
			</div>
			<div class="form-group">
				<label for="qnaContent">내용</label>
				<textarea readonly rows="5" class="form-control">${qdto.qnaContent}</textarea>
			</div>
			<div class="form-group">

				<label>첨부파일</label>
				<ul class="uploadedList clearfix">

				</ul>


				<div class="row">
					<div class="form-group">
						<button class="btn btn-warning" id="qnaupdate">수정</button>
						<button class="btn btn-primary" id="qnadelete">삭제</button>
						<button class="btn btn-danger" id="qnalist">목록</button>
					</div>

				</div>
				<!-- class = row -->


			</div>
			<!-- class = container -->
		</div>
	</div>
			<script type="text/javascript">
				$(document).ready(function() {
					$("#update").click(function() {
						location.assign("/customerservice/qnaupdate/${qdto.qnaNo}")
					});

					$("#delete").click(function() {
						location.assign("/customerservice/qnadelete/${qdto.qnaNo}")
					});

					$("#list").click(function() {
						location.assign("/customerservice/qnalist")
					});

				});
			</script>
</body>
</html>
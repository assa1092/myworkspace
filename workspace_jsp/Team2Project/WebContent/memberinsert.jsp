<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="member.command.Idchecker"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>IT 제품 리뷰</title>
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-align: center;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
	<form class="form-signin" action="memberinsert.do" method="post">
		<div class="text-center">
			<h1 class="h3 mb-3 font-weight-normal">회원 가입</h1>
			<div class="input-group mb-3">
				<input type="text" id="id" class="form-control" name="id"
					placeholder="아이디" required> <label for="inputEmail"
					class="sr-only"></label>
				<div class="input-group-append">
					<button class="btn btn-danger" id="check">중복체크</button>
				</div>
			</div>

			<label for="inputEmail" class="sr-only">이름</label> <input type="text"
				id="name" class="form-control" name="name" placeholder="이름" required><label
				for="inputEmail" class="sr-only">비밀번호</label> <input type="password"
				id="pw" class="form-control" name="pw" placeholder="비밀번호" required>
			<div class="checkbox mb-3"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">가입</button>
			<button class="btn btn-lg btn-info btn-block" type="button" onclick="location.href='reviewlist.do'">메인화면</button>
			<br>
		</div>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#check").click(function(event) {
				event.preventDefault();
				var id = $("#id").val();

				$.ajax({
					type : "get",
					url : "idchecker",
					data : {
						id : id
					},

					dataType : "text",
					success : function(result) {
						alert(result);
					}
				});

			});
		});
	</script>
	<br>
	<br>
	<br>
	<br>
</body>
</html>
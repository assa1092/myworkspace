<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="UTF-8">
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
<title>Insert title here</title>
</head>

<%-- <body>
<div style="padding: 20px 70px 20px 70px;">
<h1>로그인</h1>

<form action="memberlogin.do" method="post">
로그인 ID <br>
<input type="text" name="id" style="border:solid;" required> <br>
PassWord <br>
<input type="password" name="pw" style="border:solid;" required> <br><br>
<input type="submit" value="로그인">
</form>
<br>
<form action="memberinsertui.do" method="post">
<input type="submit" value="회원가입">
</form><br><br><br>
<jsp:include page="footer.jsp" />
</div> --%>

<body class="text-center">

	<form class="form-signin" action="memberlogin.do" method="post"
		id="login">
		<h1 class="h3 mb-3 font-weight-normal">로그인</h1>
		<label for="inputEmail" class="sr-only">아이디</label> <input type="id"
			id="inputEmail" class="form-control" name="id" placeholder="아이디"
			required autofocus> <label for="inputEmail" class="sr-only">비밀번호</label>
		<input type="password" id="inputPassword" class="form-control"
			name="pw" placeholder="비밀번호" required>

		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
		<button class="btn btn-lg btn-secondary btn-block" type="button" onclick="location.href='memberinsertui.do'">회원가입</button>
		<button class="btn btn-lg btn-info btn-block" type="button" onclick="location.href='reviewlist.do'">메인화면</button>
		
	</form>
</body>
</html>
<%@page import="member.domain.MemberDTO"%>
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

<style>
body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	/* display: flex; */
	-ms-flex-align: center;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
	text: center;
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
<body class="text-center">
	<div>
		<%
			MemberDTO login = (MemberDTO) session.getAttribute("login");
		%>
		<form class="form-signin">


			<table class="table">
				<thead class="thead  table-dark">
					<tr>
						<th colspan="2">현재 사용자 정보</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">아이디</th>
						<td>${login.id}</td>
					</tr>
					<tr>
						<th scope="row">이름</th>
						<td>${login.name}</td>
					</tr>
					
				</tbody>
			</table>

			<script>
				alert('권한이 없습니다. 감히? 당신이?');
			</script>

		</form>
		<br>
		<form class="form-signin" action="reviewlist.do" method="post">
			<button  class="btn btn-warning">목록으로
				돌아가기</button>
		</form>
		<br>
		<form class="form-signin" action="memberlogout.do" method="post">
			<button class="btn btn-dark">로그아웃</button>
		</form>
	</div>
</body>
</html>
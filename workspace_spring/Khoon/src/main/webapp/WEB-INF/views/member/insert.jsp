<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<div id ="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<div id=" container_box">
				<section id="content">
					<form action="/member/insert" method="post">
						<div class="input_area">
							<label for="userId">아이디</label>
							<input type="email" id="userId" placeholder="example@email.com" required="required"/>
						</div>
						<div class="input_area">
							<label for="userPw">패스워드</label>
							<input type="password" id="userPw" required="required"/>
						</div>
						<div class="input_area">
							<label for="userName">닉네임</label>
							<input type="text" id="userName" placeholder="닉네임을 입력하세요" required="required"/>
						</div>
						<div class="input_area">
							<label for="userPhone">연락처</label>
							<input type="text" id="userPhone" placeholder="연락처를 입력하세요" required="required"/>
						</div>
						
						<button type="submit" id="insert_btn" name="insert_btn">회원가입</button>
					</form>
				</section>
			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>
	</div>


</body>
</html>
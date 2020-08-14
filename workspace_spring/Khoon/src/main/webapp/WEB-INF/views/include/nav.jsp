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
<div style="display: inline; float: right">

			<!-- 로그인 화면 -->
			<c:if test="${!empty login }">
				${login.id }님, 안녕하세요.&nbsp;
				<button type="button" class="btn btn-primary" onclick="location.href='/member/logout'">로그아웃</button>&nbsp;
				<button type="button" class="btn btn-info"
					onclick="location.href='/member/read/${login.id}'">내정보보기</button>&nbsp;
			</c:if>
			<!-- 로그아웃 화면 -->
			<c:if test="${empty login }">
				<button type="button" class="btn btn-primary" onclick="location.href='/member/login'">로그인</button>&nbsp;
				<button type="button" class="btn btn-primary" onclick="location.href='/member/insert'">회원가입</button>&nbsp;
			</c:if>


		<%-- 	<c:if
				test="${login.property.equals('admin')||login.property.equals('manager') }">
				<button type="button" class="btn btn-secondary"
					onclick="location.href='membergrantui.do'">회원 관리</button>
			</c:if>
 --%>
			<br> <br>
			
	

</div>
<ul>
		<li>
			<a href="/member/login">로그인</a>
		</li>
		<li>
			<a href="/member/insert">회원가입</a>
		</li>
</ul>


</body>
</html>
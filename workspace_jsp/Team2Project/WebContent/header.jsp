<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>

	<a href="reviewlist.do"><img alt="IT 제품 리뷰" src="logo.png" ></a>
	<div style="width: 100%;">
		<div style="display: inline; float: left">
			<button type="button" class="btn btn-dark btn-lg"
				onclick="location.href='reviewcateselect.do?category=컴퓨터'">컴퓨터</button>
			&nbsp;
			<button type="button" class="btn btn-dark btn-lg"
				onclick="location.href='reviewcateselect.do?category=디지털'">디지털</button>
			&nbsp;
			<button type="button" class="btn btn-dark btn-lg"
				onclick="location.href='reviewcateselect.do?category=가전'">가전</button>
			&nbsp;
		</div>
		<div style="display: inline; float: right">

			<!-- 로그인 화면 -->
			<c:if test="${!empty login }">
				${login.id }님, 안녕하세요.&nbsp;
				<button type="button" class="btn btn-primary" onclick="location.href='memberlogout.do'">로그아웃</button>&nbsp;
				<button type="button" class="btn btn-info"
					onclick="location.href='memberselectById.do?id=${login.id}'">내정보보기</button>&nbsp;
			</c:if>
			<!-- 로그아웃 화면 -->
			<c:if test="${empty login }">
				<button type="button" class="btn btn-primary" onclick="location.href='memberloginui.do'">로그인</button>&nbsp;
				<button type="button" class="btn btn-primary" onclick="location.href='memberinsertui.do'">회원가입</button>&nbsp;
			</c:if>


			<c:if
				test="${login.property.equals('admin')||login.property.equals('manager') }">
				<button type="button" class="btn btn-secondary"
					onclick="location.href='membergrantui.do'">회원 관리</button>
			</c:if>

			<br> <br>

		</div>
	</div>


<br><br><br>
</header>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>

	<h1>IT 제품 리뷰</h1>
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
			<!-- <div style=display: inline align = "right"> -->
			<!-- 버튼에 스타일 적용하기 -->
			<button type="button" class="btn btn-primary"
				onclick="location.href='${empty login ? 'memberloginui.do' : 'memberlogout.do'}'">${empty login ? '로그인' : '로그아웃' }</button>
			&nbsp;
			<%-- <a href="${empty login ? 'memberloginui.do' : 'memberlogout.do'}">	${empty login ? '로그인' : '로그아웃' }</a> --%>
			<%-- <button type="button" class="btn btn-primary" onclick="location.href='${empty login ? 'memberinsertui.do' : ''}'">${empty login ? '회원가입' : ''}</button> --%>
			<%-- <a	href="${empty login ? 'memberinsertui.do' : ' '}">${empty login ? '회원가입' : ' '}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
			<!-- 로그아웃 되었을 때만 회원가입 보기 -->
			<c:if test="${empty login}">
				<button type="button" class="btn btn-primary"
					onclick="location.href='memberinsertui.do'">회원가입</button>&nbsp;
			
		</c:if>

			<c:if test="${!empty login}">
				<button type="button" class="btn btn-info"
					onclick="location.href='memberselectById.do?id=${login.id}'">내정보보기</button>&nbsp;

			<%-- <a href="memberselectById.do?id=${login.id}">내정보보기</a> --%>
			</c:if>
			<c:if
				test="${login.property.equals('admin')||login.property.equals('manager') }">
				<button type="button" class="btn btn-secondary"
					onclick="location.href='membergrantui.do'">회원 관리</button>


			</c:if>

			<br> <br>

		</div>
	</div>

	<%--<a href="grantui.do">권한부여</a>
	 --%>

	<%--<% if(manager){
		out.print("<a href=");
		out.print('"');
		out.print("grantui.do");
		out.print('"');
		out.print(">권한부여</a>");
	}--%>





	<%
		// <c:forEach items="${list}" var="dto">
		//<a href="selectById.do?id=${dto.id}">${dto.id} : ${dto.name}</a><br>
		//</c:forEach>
	%>
<br><br><br>
</header>
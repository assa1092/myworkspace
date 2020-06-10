<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>IT 제품 리뷰</title>
</head>
<body>
	<div style="padding: 20px 70px 20px 70px;">
		<h1>IT 제품 리뷰 리스트</h1>
		<a href="${empty login ? 'memberloginui.do' : 'memberlogout.do'}">
			${empty login ? '로그인' : '로그아웃' }</a> <a
			href="${empty login ? 'memberinsertui.do' : ' '}">${empty login ? '회원가입' : ' '}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		<c:if test="${!empty login}">
			<a href="memberselectById.do?id=${login.id}">내정보보기</a>
		</c:if>
		<c:if test="${manager}">
			<a href="membergrantui.do">권한부여</a>
		</c:if>
		<button type="button" class="btn btn-primary"
			onclick="location.href='reviewinsertui.do'" style="float: right">글쓰기</button>

		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>카테고리</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>별점</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.num }</td>
						<td><a href="reviewread.do?num=${dto.num }">${dto.title }</a></td>
						<td>${dto.id }</td>
						<td>${dto.category }</td>
						<td><c:choose>
								<c:when test="${fn:length(dto.writeday)>10 }">
									<c:out value="${fn:substring(dto.writeday,0,10)}" />
								</c:when>
							</c:choose></td>
						<td>${dto.readcnt }</td>
						<td>${dto.starpoint }</td>
					</tr>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</div>
</html>
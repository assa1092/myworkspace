<%@page import="kr.co.domain.ReviewDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Management</title>
<%@ include file="../include/head.jsp"%>
</head>
<body>
	<%@ include file="../include/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="../include/sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">REVIEW BOARD LIST</h1>
				<div class="row">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th style="width: 50%">제목</th>
								<th>작성자</th>
								<th>평점</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reviewDto}" var="dto">
								<tr>
									<td>${dto.reviewNo}</td>
									<td><a href="/board/read/${dto.reviewNo}"></a>${dto.reviewTitle}</td>
									<td>${dto.memberId}</td>
									<td>${dto.reviewScore}</td>
									<td>${dto.reviewRegDate}</td>
									<td>${dto.reviewReadCnt}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<%@ include file="../include/footer.jsp"%>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
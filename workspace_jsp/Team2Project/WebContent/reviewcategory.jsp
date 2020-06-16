<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="padding: 20px 70px 20px 70px;">
		<jsp:include page="header.jsp" />
		<h1>카테고리: ${category}</h1>
		<table class="table table-striped">
			<thead bgcolor="pink">
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
				<c:forEach items="${list}" var="dto">
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

				</c:forEach>
			</tbody>
		</table>
		<div align="center">
			<c:if test="${to.curPage != 1 }">
				<a
					href="reviewcateselect.do?category=${category }&curPage=${(to.curPage-1) >0 ? (to.curPage-1) : 1} ">&laquo;</a>&nbsp;&nbsp;
</c:if>

			<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}"
				var="idx">

				<c:if test="${to.curPage == idx }">
					<a style="font-size: 20px;"
						href="reviewcateselect.do?curPage=${idx}&category=${category}">${idx}</a> &nbsp;&nbsp;
      </c:if>

				<c:if test="${to.curPage != idx }">
					<a style="text-decoration: none"
						href="reviewcateselect.do?curPage=${idx}&category=${category}">${idx}</a> &nbsp;&nbsp;
      </c:if>

			</c:forEach>
			<c:if test="${to.curPage != to.totalPage}">
				<a
					href="reviewcateselect.do?category=${category}&curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage }">&raquo;</a>
			</c:if>
			<div style="float: left">
				<button type="button" class="btn btn-outline-success"
					onclick="location.href='reviewlist.do'">목록</button>
			</div>
			<br> <br> <br><jsp:include page="footer.jsp" />
		</div>
</body>
</html>
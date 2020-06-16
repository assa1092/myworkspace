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
<title>Insert title here</title>
</head>
<body>
<div style="padding: 20px 70px 20px 70px;">
<jsp:include page="header.jsp" />
	<h1>검색결과</h1>
	<table class="table table-striped">
			<thead  bgcolor = "pink">
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
			<c:forEach items="${ list}" var="dto">
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
			
	<button type="button" class="btn btn-outline-success" onclick="location.href='reviewlist.do'">목록</button>
	</div>
	
	<br><br><br><jsp:include page="footer.jsp" />
	</div>
</body>
</html>
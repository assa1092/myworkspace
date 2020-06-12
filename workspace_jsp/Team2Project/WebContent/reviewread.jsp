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
<jsp:include page="header.jsp" />
	
		<h1>상세 보기</h1>
		<table class="table table-striped">
			<tr>
				<th>번호</th>
				<th>작성일</th>
			</tr>
			<tr>
				<td>${list.num }</td>
				<td><c:choose>
						<c:when test="${fn:length(list.writeday)>10 }">
							<c:out value="${fn:substring(list.writeday,0,10)}" />
						</c:when>
					</c:choose></td>
			</tr>
			<tr>
				<th>카테고리</th>
				<th>제목</th>
			</tr>
			<tr>
				<td>${list.category }</td>
				<td>${list.title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<th>내용</th>
			</tr>
			<tr>
				<td>${list.id }</td>
				<td>${list.content }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<th>별점</th>
			</tr>
			<tr>
				<td>${list.readcnt }</td>
				<td>${list.starpoint }</td>

			</tr>
			
		</table>
		<c:if test="${!empty login}">
		<button type="button" class="btn btn-outline-success" onclick="location.href='reviewupdateui.do?num=${list.num }'">수정</button>
		 <button type="button" class="btn btn-outline-success" onclick="location.href='reviewdelete.do?num=${list.num }&id=${list.id }'">삭제</button>
		 </c:if>
			<button type="button" class="btn btn-outline-success" onclick="location.href='reviewlist.do'">목록</button>
		
	<br><br><br>
	<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
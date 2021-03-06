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
<title>${list.title}</title>
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
	<div style="padding: 20px 70px 0px 70px;">
		<jsp:include page="header.jsp" />

		<h1>상세 보기</h1>
		<div style="text-align: center;">
			<img alt="" src="upload/${upload.fileName }"
				style="width: auto; height: auto; max-height: 400px; max-width: 600px;"><br>
		</div>

		<h4>${list.category}&gt;</h4>

		<table class="table">
			<tr><td style="font-size:20px; background-color: lightgray;"  colspan=2><b>${list.title}</b>
			</tr>
			<tr><td><b><a href="memberselectById.do?id=${list.id }">${list.id}</a>&nbsp;님</b>
			<td style="text-align: right;" class="text-muted">
			<svg class="bi bi-clock" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  			<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm8-7A8 8 0 1 1 0 8a8 8 0 0 1 16 0z"/>
  			<path fill-rule="evenodd" d="M7.5 3a.5.5 0 0 1 .5.5v5.21l3.248 1.856a.5.5 0 0 1-.496.868l-3.5-2A.5.5 0 0 1 7 9V3.5a.5.5 0 0 1 .5-.5z"/>
			</svg>
			${list.writeday }
			</tr>
			<tr><td colspan=2 style="text-align: right;">
			<svg class="bi bi-eye" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
 	 		<path fill-rule="evenodd" d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.134 13.134 0 0 0 1.66 2.043C4.12 11.332 5.88 12.5 8 12.5c2.12 0 3.879-1.168 5.168-2.457A13.134 13.134 0 0 0 14.828 8a13.133 13.133 0 0 0-1.66-2.043C11.879 4.668 10.119 3.5 8 3.5c-2.12 0-3.879 1.168-5.168 2.457A13.133 13.133 0 0 0 1.172 8z"/>
  			<path fill-rule="evenodd" d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
			</svg>&nbsp;
			${list.readcnt }
			</tr>
		</table>
		<table class="table table-bordered">
			<tr>
				<td><div style="min-height: 200px; font-size: 20px;"><%-- ${list.content } --%>
				<pre><c:out value="${list.content}" /></pre></div>


			</tr>
		</table>
		<table class="table table-borderless">
			<tr>
				<td>별점 : ${list.starpoint }
			</tr>
		</table>


		<%-- 
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
		--%>

		

		<c:if test="${sessionScope.login.id.equals(list.id) }">
			<button type="button" class="btn btn-outline-success"
				onclick="location.href='reviewupdateui.do?num=${list.num }&id=${list.id }'">수정</button>
		</c:if>
		
		<c:if test="${sessionScope.login.id.equals(list.id) || (login.property.equals('admin') || login.property.equals('manager')) }">
			<button type="button" class="btn btn-outline-success"
				onclick="location.href='reviewdelete.do?num=${list.num }&id=${list.id }'">삭제</button>

		</c:if>

		<button type="button" class="btn btn-outline-success"
			onclick="location.href='reviewlist.do'">목록</button>

		<br> <br> <br>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
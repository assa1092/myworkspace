<%@page import="review.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>

</head>
<body>
	<jsp:include page="header.jsp"/>
	<%-- <div style="padding: 20px 70px 0px 70px;">
	<h1> IT 제품 리뷰 리스트</h1>
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

	</div> --%>
	
	<table border="1" class="table table-striped">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">카테고리</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
				<th scope="col">별점</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
					ReviewDTO notice = (ReviewDTO)request.getAttribute("notice");
				%>
				<td>공 지</td>
				<td><a href="reviewread.do?num=${notice.num}">${notice.title}</a></td>
				<td>${notice.id}</td>
				<td>${notice.category}</td>
				<td><c:choose>
						<c:when test="${fn:length(notice.writeday) >10 }">
							<c:out value="${fn:substring(notice.writeday, 0, 10) }"></c:out>
						</c:when>
					</c:choose>
				</td>
				<td>${notice.readcnt}</td>
				<td>${notice.starpoint}</td>
				
			
			</tr>
		
		
		
		
			<c:forEach items="${list}" var = "dto">
				<tr>
					<td>${dto.num}</td>
					<td><a href="reviewread.do?num=${dto.num}">${dto.title}</a></td>
					<td><a href="memberselectById.do?id=${dto.id}">${dto.id}</a></td>
					<td>${dto.category}</td>
					<td><c:choose>
						<c:when test="${fn:length(dto.writeday) >10 }">
							<c:out value="${fn:substring(dto.writeday, 0, 10) }"></c:out>
						</c:when>
						</c:choose>
					</td>
					<td>${dto.readcnt}</td>
					<td>${dto.starpoint}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<button type="button" class="btn btn-primary" onclick="location.href='reviewinsertui.do'">글쓰기</button>&nbsp;
	
	
	</div>
	<!--  
	<a class="btn btn-default">글쓰기</a>
	<button type="button" class="btn btn-primary" onclick="location.href='memberinsertui.do'">회원가입</button>&nbsp;
	-->

	<!-- &laquo; 왼쪽 화살표...  &raquo; 오른쪽 화살표 -->
	
	<!-- &laquo; 왼쪽 화살표 누르면 이전 페이지로 이동. -->
	<!-- 페이징처리 -->
		<div align="center">
      
      <ul class="pagination justify-content-center" >
         <c:if test="${to.curPage != 1 }">
            <li class="page-item"><a class="page-link" href="reviewlist.do?curPage=${(to.curPage-1) >0 ? (to.curPage-1) : 1} ">&laquo;</a></li>
		</c:if>

         <c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}"
            var="idx">

            <c:if test="${to.curPage == idx }">
               <li class="page-item active"><a class="page-link" href="reviewlist.do?curPage=${idx}">${idx}</a></li> 
      		</c:if>

            <c:if test="${to.curPage != idx }">
               <li class="page-item"><a class="page-link" 
                  href="reviewlist.do?curPage=${idx}">${idx}</a></li> 
     		</c:if>

         </c:forEach>
         
         <c:if test="${to.curPage != to.totalPage}">
            <li class="page-item"><a class="page-link"   href="reviewlist.do?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage }">&raquo;</a></li>
         </c:if>
         </ul>

        
        
      
         
      </div>
      
      
      
      
  
	

</body>
</html>
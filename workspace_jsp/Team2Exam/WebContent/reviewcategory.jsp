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
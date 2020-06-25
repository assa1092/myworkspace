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
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
<div style="padding: 20px 70px 0px 70px;">

<jsp:include page="header.jsp" />
	<h1>검색결과</h1>
	<table class="table table-striped">
			<thead  bgcolor = "pink">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${list }" var="dto">

					<tr>
						<td>${dto.num }</td>
						<td width="300px">
							<c:forEach begin="1" end="${dto.repIndent}">
								&nbsp;re:
							</c:forEach> <a href="boardread.do?num=${dto.num }">${dto.title }</a></td>
						<td><a href="memberselectById.do?id=${dto.writer }">${dto.writer }</a></td>
						<td><c:choose>
								<c:when test="${fn:length(dto.writeday)>10 }">
									<c:out value="${fn:substring(dto.writeday,0,10)}" />
								</c:when>
							</c:choose></td>
						<td>${dto.readcnt }</td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
		<%-- 
		<!-- 페이징처리 -->
		<div align="center">
      
      <ul class="pagination justify-content-center" >
         <c:if test="${to.curPage != 1 }">
            <li class="page-item"><a class="page-link" href="boardsearch.do?curPage=${(to.curPage-1) >0 ? (to.curPage-1) : 1} ">&laquo;</a></li>
		</c:if>

         <c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}"
            var="idx">

            <c:if test="${to.curPage == idx }">
               <li class="page-item active"><a class="page-link" href="boardsearch.do?curPage=${idx}">${idx}</a></li> 
      		</c:if>

            <c:if test="${to.curPage != idx }">
               <li class="page-item"><a class="page-link" 
                  href="boardsearch.do?curPage=${idx}">${idx}</a></li> 
      		</c:if>

         </c:forEach>
         <c:if test="${to.curPage != to.totalPage}">
            <li class="page-item"><a class="page-link"   href="boardsearch.do?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage }">&raquo;</a></li>
         </c:if>
         </ul>
--%>
         <br>
			
	<button type="button" class="btn btn-outline-success" onclick="location.href='boardlist.do'">목록</button>
	</div>
	
	<br><br><br><jsp:include page="footer.jsp" />
	
</body>
</html>
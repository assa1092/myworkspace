<%@page import="review.domain.ReviewDTO"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil"%>
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
<script type="text/javascript">
	function managerdelete(num) {
		var isOk = confirm("삭제하시겠습니까?");
		if (isOk == true) {
			location.href = "reviewmanagerdelete.do?num=" + num;
		}
	}
</script>

<title>IT 제품 리뷰</title>
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
	<div style="padding: 20px 70px 0px 70px;">
		<jsp:include page="header.jsp" />
		<div align="right">
		<h1>자유게시판&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-info" 
				onclick="location.href='reviewlist.do'">리뷰게시판</button></h1>
		</div>
	
	<!-- 
			<div align="left" style="display: inline-block">
				<h1>자유게시판&nbsp;&nbsp;&nbsp;</h1>
			</div>
			<div  style="display: inline-block">
					<button type="button" class="btn btn-info" 
         	   onclick="location.href='reviewlist.do'">리뷰게시판</button>
			</div>
	 -->	
		
		<table class="table table-striped">
		 <colgroup>
            <c:if
               test="${login.property.equals('customer')||empty login.property}">
               <col width="8%" />
               <col width="24%" />
               <col width="16%" />
               <col width="16%" />
               <col width="16%" />
               <col width="12%" />
               <col width="8%" />
            </c:if>
            <c:if
               test="${login.property.equals('admin')||login.property.equals('manager') }">
               <col width="7%" />
               <col width="21%" />
               <col width="14%" />
               <col width="14%" />
               <col width="14%" />
               <col width="10%" />
               <col width="7%" />
               <col width="13%" />
            </c:if>
         </colgroup>
		
			<thead  bgcolor = "pink">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
					<th>조회수</th>
					

					<c:if test="${login.property.equals('admin')||login.property.equals('manager') }">
						<th>삭제</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
			<%-- 
				<tr style="font-weight:bold">
					<!-- EL로 표기하기 위한 데이터 바인딩 -->
					<%ReviewDTO notice = (ReviewDTO) request.getAttribute("notice"); %>
						<td>${notice.num }</td>
						<td><a href="reviewread.do?num=${notice.num }">${notice.title }</a></td>
						<td>${notice.id }</td>
						<td>${notice.category }</td>
						<td><c:choose>
							<c:when test="${fn:length(notice.writeday)>10 }">
								<c:out value="${fn:substring(notice.writeday,0,10)}" />
							</c:when>
						</c:choose></td>
						<td>${notice.readcnt }</td>
						<td>${notice.starpoint }</td>
						<c:if
						test="${login.property.equals('admin')||login.property.equals('manager') }">
						<td></td>
					</c:if>
					</tr>
			--%>	
					<c:forEach items="${list }" var="dto">
				
				<tr>
					<td>${dto.num }</td>
					<td width="300px">
						<c:forEach begin ="1" end ="${dto.repIndent}">
							&nbsp;&nbsp;
						</c:forEach>
							<a href="boardread.do?num=${dto.num }">${dto.title }</a>
					</td>
					<td><a href="memberselectById.do?id=${dto.writer }">${dto.writer }</a></td>
					<td><c:choose>
							<c:when test="${fn:length(dto.writeday)>10 }">
								<c:out value="${fn:substring(dto.writeday,0,10)}" />
							</c:when>
						</c:choose></td>
					<td>${dto.readcnt }</td>
					
					<c:if test="${login.property.equals('admin')||login.property.equals('manager') }">
						<td>
							<button onclick="managerdelete('${dto.num}')">글 삭제</button>
						</td>
					</c:if>
				</tr>
				
				</c:forEach>
			</tbody>
		</table>
		<!-- 페이징처리 -->
		<div align="center">
      
      <ul class="pagination justify-content-center" >
         <c:if test="${to.curPage != 1 }">
            <li class="page-item"><a class="page-link" href="boardlist.do?curPage=${(to.curPage-1) >0 ? (to.curPage-1) : 1} ">&laquo;</a></li>
		</c:if>

         <c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}"
            var="idx">

            <c:if test="${to.curPage == idx }">
               <li class="page-item active"><a class="page-link" href="boardlist.do?curPage=${idx}">${idx}</a></li> 
      		</c:if>

            <c:if test="${to.curPage != idx }">
               <li class="page-item"><a class="page-link" 
                  href="boardlist.do?curPage=${idx}">${idx}</a></li> 
      		</c:if>

         </c:forEach>
         <c:if test="${to.curPage != to.totalPage}">
            <li class="page-item"><a class="page-link"   href="boardlist.do?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage }">&raquo;</a></li>
         </c:if>
         </ul>

         <br>
         <div style="float: right">
      <c:if test="${!empty login}">
         <button type="button" class="btn btn-primary btn-lg"
            onclick="location.href='boardinsertui.do'">글쓰기</button>
      </c:if>
      </div>
      
         <form action="boardsearch.do" method="get">
            <select name="category">
               <option value="title">제목</option>
               <option value="id">글쓴이</option>
               <option value="titlecontent">제목 + 내용</option>
            </select> <input name="search" required> <input type=submit
               value="검색">
         </form>
      </div>
      
      <br> <br> <br> <br>
      
      <jsp:include page="footer.jsp" />
   </div>

</body>

</html>
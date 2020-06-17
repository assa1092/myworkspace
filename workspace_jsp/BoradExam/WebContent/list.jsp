<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<a href="insertui.do">글쓰기</a>
	
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>writeday</th>
				<th>readcnt</th>
				
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list }" var="dto"> 
				<tr>
				<td>${dto.num }</td>
				<td width="300px">
				
					<!-- 댓글쓰면 들여쓰기... -->
					<!-- begin포함 end 포함...  -->
					<!-- begin = "0" 부터하면 원글도 들여쓰기해서....-->
					<c:forEach begin="0" end="${dto.repIndent}">
						&nbsp;&nbsp;
					</c:forEach>
					<a href="read.do?num=${dto.num}">${dto.title }</a>
					
				
				</td>
				<td>${dto.writer }</td>
				<td>${dto.writeday }</td>
				<td>${dto.readcnt }</td>
				
			</tr>
			
			</c:forEach>
		</tbody>
		
	</table>
	<!-- &laquo; 왼쪽 화살표...  &raquo; 오른쪽 화살표 -->
	
	<!-- &laquo; 왼쪽 화살표 누르면 이전 페이지로 이동. -->
	<div align = "center">
	<c:if test="${to.curPage != 1}">
		<a href="list.do?curPage=${to.curPage-1}">&laquo;</a>&nbsp;&nbsp;
	</c:if>
	
	 <%--
	 <a href="list.do?curPage=${(to.curPage-1) >0 ? (to.curPage-1) : 1} ">&laquo;</a>&nbsp;&nbsp;
	 --%>
	<!-- 페이징....idx =>index 약자.. -->
	<!-- list.do 페이지로 가는데...인덱스 1, 2, 3, 이런식으로 값을 가지고 간다.. -->
	<!-- 페이징 처리를 위한 객체 to에서 동적인 구조로 beginPageNum 로 시작 stopPageNum 끝.-->
	
	<c:forEach begin="${to.beginPageNum}" end ="${to.stopPageNum}" var ="idx">
		<!-- 현재 페이지와 인덱스 페이지가 같으면. 숫자가 커보이게...-->
		<c:if test="${to.curPage == idx }">
			<a style="font-size:20px;" href="list.do?curPage=${idx}">${idx}</a> &nbsp;&nbsp;
		</c:if>
		<!-- 현재 페이지와 인덱스 페이지가 다르면. 밑줄 안보이게...-->
		<c:if test="${to.curPage != idx }">
			<a style="text-decoration:none" href="list.do?curPage=${idx}">${idx}</a> &nbsp;&nbsp;
		</c:if>
		
	</c:forEach>
	<!-- &raquo; 오른쪽 화살표 누르면 다음 페이지로 이동. -->
	
	<%--
	<a href="list.do?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage }">&raquo;</a>
		--%>
	 <c:if test="${to.curPage != to.totalPage}">
		<a href="list.do?curPage=${to.curPage+1}">&raquo;</a>
	</c:if>
</div>
	
	
	
	

</body>
</html>
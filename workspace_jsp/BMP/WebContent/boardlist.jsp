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
<%--
table.type11 { border-collapse: separate; border-spacing: 1px; text-align: center; line-height: 1.5; margin: 20px 10px;}
table.type11 th { width: 155px; padding: 10px; font-weight: bold; vertical-align: top; color: #fff; background: #ce4869 ;}
table.type11 td { width: 155px; padding: 10px; vertical-align: top; border-bottom: 1px solid #ccc; background: #eee;}
--%>


table.ex1 {width:98%; margin:0 auto; text-align:right; border-collapse:collapse}
.ex1 th, .ex1 td {padding:5px 10px}
.ex1 caption {font-weight:700; font-size:20px; padding:5px; color:#1BA6B2; text-align:left; margin-bottom:5px}
.ex1 thead th {background:#ABC668; color:#fff; text-align:center; border-right:1px solid #fff}
.ex1 tbody th {text-align:left; width:12%}
.ex1 tbody td {text-align:center;}
.ex1 tbody td.title {text-align:left;}
.ex1 tbody tr.odd {background:#f9f9f9}
.ex1 tbody tr.odd th {background:#f2f2f2}
.ex1 tbody tr:hover {background:#F3F5BB}
.ex1 tbody tr:hover th {background:#F2F684; color:#1BA6B2}
.ex1 tfoot tr {border-top:6px solid #E9F7F6; color:#1BA6B2}
.ex1 tfoot th {text-align:left; padding-left:10px}




</style>
</head>
<body>
<div style="padding: 20px 70px 0px 70px;">
	&nbsp;&nbsp;&nbsp;&nbsp;<h1>게시글 목록</h1>
	
	
	<table class="ex1 table table-striped">
		<thead>
			<tr>
				<th>Num</th>
				<th>Title</th>
				<th>Writer</th>
				<th>Writeday</th>
				<th>readcnt</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var = "dto">
				<tr>
					<td>${dto.num}</td>
					<td width="300px" class="title">
						<c:forEach begin="0" end="${dto.repIndent}">
							&nbsp;&nbsp;
						</c:forEach>
						<a href="boardread.do?num=${dto.num}">${dto.title} </a>
					</td>
					<td>${dto.writer}</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	&nbsp;&nbsp;<a href="boardinsertui.do">글쓰기</a>
	
	
	<!-- &laquo; 왼쪽 화살표...  &raquo; 오른쪽 화살표 -->
	
	<!-- &laquo; 왼쪽 화살표 누르면 이전 페이지로 이동. -->
	<div align="center">
	<c:if test="${to.curPage != 1}">
		<a href="boardlist.do?curPage=${to.curPage-1}">&laquo;</a>&nbsp;&nbsp;
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
			<a style="font-size:20px;" href="boardlist.do?curPage=${idx}">${idx}</a> &nbsp;&nbsp;
		</c:if>
		<!-- 현재 페이지와 인덱스 페이지가 다르면. 밑줄 안보이게...-->
		<c:if test="${to.curPage != idx }">
			<a style="text-decoration:none" href="boardlist.do?curPage=${idx}">${idx}</a> &nbsp;&nbsp;
		</c:if>
		
	</c:forEach>
	<!-- &raquo; 오른쪽 화살표 누르면 다음 페이지로 이동. -->
	<%--
	<a href="list.do?curPage=${(to.curPage+1) < to.totalPage? (to.curPage+1) : to.totalPage }">&raquo;</a>
	--%>
	 <c:if test="${to.curPage != to.totalPage}">
		<a href="boardlist.do?curPage=${to.curPage+1}">&raquo;</a>
	</c:if>
	</div>

</div>
</body>
</html>
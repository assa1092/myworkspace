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
				<th>repRoot</th>
				<th>repStep</th>
				<th>repIndent</th>
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
				<td>${dto.repRoot }</td>
				<td>${dto.repStep }</td>
				<td>${dto.repIndent }</td>
			</tr>
			
			</c:forEach>
		</tbody>
		
	</table>
	
	
	

</body>
</html>
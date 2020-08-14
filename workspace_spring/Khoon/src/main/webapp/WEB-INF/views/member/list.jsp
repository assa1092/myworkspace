<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>
	<jsp:include page="../include/nav.jsp"></jsp:include>

	<section>
		<div class="container">
			<div class="row text-center">
				<h1>회원 목록</h1>
			</div>
			
			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="th-center">아이디</th>
							<th class="th-center">이름</th>
							<th class="th-center">나이</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${list}" var ="dto">
							<tr>
							
								<td>${dto.id}</td>
								<td><a href="/member/read/${dto.id}">${dto.name}</a></td>
								<td>${dto.age}</td>	
							</tr>	
						</c:forEach>
					</tbody>
					
				</table>	
			</div>
			
		</div>
	</section>

	<br><br><br><br>
	<jsp:include page="../include/footer.jsp"></jsp:include>

</body>
</html>
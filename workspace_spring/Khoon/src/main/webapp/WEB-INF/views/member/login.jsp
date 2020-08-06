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
	
	<section id="container">
	<div class="container" style="width: 300px">
		<form action="/member/loginpost" method="post">
			<div class="form-group ">
					<input id="id" name="id" class="form-control" 
						placeholder="아이디" required="required">
			</div>
			<div class="form-group ">
					<input id="pw" name="pw" class="form-control" 
					placeholder="비밀번호" required="required">
			</div>
			<div class="from-group">
				<button type="submit" class="btn btn-primary form-control">로그인</button>
			</div>
		</form>
	</div>		
	</section>

	<jsp:include page="../include/footer.jsp"></jsp:include>


</body>
</html>
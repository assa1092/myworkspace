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
		<form action="/member/update" method="post">
			<label>아이디 </label><input name="id" value="${dto.id }" readonly><br>
			<label>비밀번호</label><input name="pw" value="${dto.pw }"><br>
			<label>이름</label><input name="name" value="${dto.name }"><br>
			<label>나이 </label><input name="age" value="${dto.age }"><br>

		</form>
		
		
		<button class="btn btn-primary" id="update_btn">수정</button>
		<button class="btn btn-info" id="list_btn">목록</button>
	</section>

	<jsp:include page="../include/footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#update_btn").click(function(){
				$("form").submit();
			});
		
			$("#list_btn").click(function(){
				location.assign("/member/list");
			});
		});
	</script>

</body>
</html>
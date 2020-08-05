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
	
		<label>아이디 </label><input name="id" value ="${dto.id}" readonly><br>
		<label>이름</label><input name="name" value ="${dto.name}" readonly><br> 
		<label>나이 </label><input name="age" value ="${dto.age}" readonly><br>


		<div class="row">
			<div class="form-group">
				<button class="btn btn-primary" id="update_btn">수정</button>
				<button class="btn btn-danger" id="delete_btn">삭제</button>
				<button class="btn btn-info" id="list_btn">목록</button>
			</div>
		</div>

	</section>

	<jsp:include page="../include/footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#update_btn").click(function(){
				location.assign("/member/update/${dto.id}");
			});
			$("#delete_btn").click(function(){
				location.assign("/member/delete/${dto.id}");
			});
			$("#list_btn").click(function(){
				location.assign("/member/list");
			});
		});
	</script>

</body>
</html>
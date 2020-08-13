<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
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
	<div class="container">
		<div class="row text-center">
			<h1>판매상품관리</h1>
		</div>
		<div class="row">
			<form action="/admin/insert" method="post">
				<div class="form-group">
					<label for="productNo">상품번호</label>
					<input type="text" id="productNo" name="productNo">
				</div>
				<div class="form-group">
					<label for="productName">상품이름</label>
					<input type="productName" id="productName" name="productNo">
				</div>
				<div class="form-group">
					<label for="productPrice">가격</label>
					<input type="text" id="productPrice" name="productPrice">
				</div>
				
			</form>
		</div>
	</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: black;
	text-decoration: underline;
}

.underlinegray {
	border-bottom: 1px solid gray;
}

.underlineblack {
	border-bottom: 1px solid black;
}

.marginside {
	margin-left: 2px;
	margin-right: 2px;
}

.marginleft2px {
	margin-left: 2px;
}

.marginright2px {
	margin-right: 2px;
}

.btn-none {
	border: 0px;
	width: 100%;
	height: 300px;
	background-color: white;
	color: blue;
}

.btn-none:hover {
	border: 1px solid blue;
}
</style>

</head>
<body>
	<jsp:include page="../include/header.jsp" flush="false" />
	<div class="container">
		<div class="row" style="max-width: 100%; height: auto;">
			<img alt="" src="https://pepem1.cafe24.com/pethroom/images/photo_review_F_01.jpg">
			<img alt="" src="https://pepem1.cafe24.com/pethroom/images/photo_review_F_02.jpg">
			베스트 리뷰 들어가야 됨
			<img alt="" src="https://pepem1.cafe24.com/pethroom/images/photo_review_F_03.jpg">
			<img alt="" src="https://pepem1.cafe24.com/pethroom/images/photo_review_F_04.jpg">
			<img alt="" src="https://pepem1.cafe24.com/pethroom/images/photo_review_F_05.jpg">
		</div>
	</div>
</body>
</html>
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
<div class="container"><!-- class="container-fluid" 왼쪽으로 붙어서 정렬... -->
		<div class="row text-center">
			<h1>글수정</h1>
		</div>
		<div class="row"> <!-- class="row" 한 줄을 의미... -->
			
			<form action="/board/update" method="post">
				<input type="hidden" name="bno" value="${vo.bno}">
				<div class="form-group">
					<label for="title">제목</label><!-- for="title" 제목 클릭시 name="title"으로 포커스 가게... -->
					<input value="${vo.title}" name="title" id="title" class="form-control"><!-- input 태그가 한줄로 모서리 둥글게...class="form-control" -->
					
				</div>
				<div class="form-group">
					<label for="writer">작성자</label>
					<input value="${vo.writer}"  name="writer" id="writer" class="form-control">
				</div>
				
				<div class="form-group">
					<label for="content">내용</label>
					<textarea rows="5" name="content" id="content" class="form-control">${vo.content}</textarea>
				</div>		
			</form>
			
			<div class="form-group">
				<button class="btn btn-danger" id="updatebtn">수정</button><!-- 문맥 테그 primary, warning,danger, link, default... -->
				<button class="btn btn-danger" id="listbtn">목록</button>
			</div>	
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#updatebtn").click(function(){
				$("form").submit();
			});
			$("#listbtn").click(function(){
				location.assign("/board/list")
			});
		});
	</script>



</body>
</html>
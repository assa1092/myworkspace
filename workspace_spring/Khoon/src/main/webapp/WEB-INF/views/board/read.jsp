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
	
		<div class="container">
			<div class="row text-center">
				<h1>글 자세히 보기</h1>
			</div>
			
			<div class="row">
				<form action="/board/insert" method="post">
					<div class="form-group">
						<label for="title">제목</label>
						<input readonly value="${vo.title}" class="form-control">
					</div>
					<div class="form-group">
						<label for="writer">작성자</label>
						<input  readonly value="${vo.writer}" class="form-control">
					</div>
					<div class="form-group">
						<label for="content">내용</label>
						<input  readonly value="${vo.content}" class="form-control">
					</div>
				</form>
				
				<div class="form-group">
					<button class="btn btn-info" id="reply_form">댓글</button>
					<button class="btn btn-warning" id="update">수정</button>
					<button class="btn btn-danger" id="delete">삭제</button>
					<button class="btn btn-primary" id="list">목록</button>
				</div>
			</div>
			
			<!-- 댓글 -->
		<div class="row">

			<!-- collapse 댓글버튼 누르면 댓글 작성화면 나오게.... -->
			<div id="mycollapse" class="collapse">
				<div class="form-group">
					<label for="replyer">작성자</label> <input id="replyer"
						class="form-control">
				</div>
				<div class="form-group">
					<label for="replytext">내 용</label> <input id="replytext"
						class="form-control">
				</div>

				<div class="form-group">
					<button id="replyInsertBtn" class="btn btn-primary">댓글 등록</button>
				</div>
			</div>
		</div><!-- 댓글 .row -->
		
		<!-- 덮어쓰기 할꺼라 없는거나 마찬가지 -->
		<div id="replies" class="row">
			<div class="panel panel-success">
				<div class="panel-heading">
					<span>rno: 3 </span>, <span>작성자 : 홍길동</span>
					<!-- class="pull-right" 오른쪽으로 붙게... -->
					<span class="pull-right">2020년07월07일...</span>
				</div>
				<div class="panel-body">
					<p>댓글 내용입니다</p>
					<button data-name="홍길동" data-rno="3" class="btn btn-warning btn-xs replymodify">수정</button>
					<button data-rno="3" class="btn btn-danger btn-xs replydelete">삭제</button>
				</div>
			</div>
		</div><!-- class = row -->
		
	
	</div><!-- /.container -->

	
	





	</section>

	<jsp:include page="../include/footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(document).ready(function(){

			$("#reply_form").click(function(){
				$("#mycollapse").collapse("toggle");
			});
			
			$("#update").click(function(){
				location.assign("/board/update/${vo.bno}");
			});
			$("#delete").click(function(){
				location.assign("/board/delete/${vo.bno}");
			});
			$("#list").click(function(){
				location.assign("/board/list");
			});
		});

	</script>


</body>
</html>
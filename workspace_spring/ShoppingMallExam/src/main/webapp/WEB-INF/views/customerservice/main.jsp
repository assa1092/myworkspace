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
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: underline;}
 .underlinegray {border-bottom: 1px solid gray;}
 .underlineblack {border-bottom: 1px solid black;}
 .marginside {margin-left:2px; margin-right:2px;}
 .marginleft2px {margin-left:2px;}
 .marginright2px {margin-right:2px;}
 .btn-none {border: 0px;
 			width: 100%;
 			height: 300px;
 			background-color: white;
 			color : blue;	
 			}
 .btn-none:hover{border: 1px solid blue;}
 
</style>

</head>
<body>
<jsp:include page="../include/header.jsp" flush="false"/>
	<div class="container">
		<div class="row">
			<div class="col-sm-10">
				<div class="row">
					<h1>고객만족센터</h1>
				</div>
				<div class="row">
					PETHROOM은 여러분들과 반려동물의 행복한 욕실을 만들기 위해 최선을 다하고 있습니다.
'상품, 배송, 사용 문의 등의 궁금한 점은 여기 고객만족센터'를 이용해주시기 바랍니다.
				</div>
				<div class="row">
					<div class="col-sm-4">
						<button class="btn-none" id="btn-faq">FAQ</button>
					</div>
					<div class="col-sm-4">
						<button class="btn-none" id="btn-qna">Q&A</button>
					</div>
					<div class="col-sm-4">
						<button class="btn-none" id="btn-petmily">PETMIlY</button>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="row underlineblack marginside">
							<div class="col-sm-10">
								Notice
							</div>
							<div class="col-sm-2">
								<a href="/customerservice/notice">더보기</a>
							</div>
						</div>
						<div class="row marginside">
							<div class="col-sm-9 underlinegray">
							공지사항가져오기
							</div>
							<div class="col-sm-3 underlinegray">
							작성일 받기
							</div>
						
						</div>
					</div>
					<div class="col-sm-6">
						<div class="row underlineblack marginside">
							<div class="col-sm-10">
								Event
							</div>
							<div class="col-sm-2">
								<a href="/customerservice/event">더보기</a>
							</div>					
						</div>
						<div class="row marginside">
							이벤트배너
						</div>
					</div>
				</div>
				<div class="row underlineblack marginside">
					<div class="col-sm-11">
						INQUIRY
					</div>
					<div class="col-sm-1">
						<a href="/customerservice/inquiry">더보기</a>
					</div>
				</div>
				<div class="row marginside">
					<div class="row underlinegray marginside">
						<div class="col-sm-10">
						문의가져오기
						</div>
						<div class="col-sm-2">
						문의작성일 가져오기
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-2">
				sidebar
			</div>
		</div>
		<div class="row">
			footer
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#btn-faq').click(function(){
				location.assign("/customerservice/faq");
			});
			$('#btn-qna').click(function(){
				location.assign("/customerservice/qna");
			});
			$('#btn-petmily').click(function(){
				location.assign("/customerservice/petmily");
			});
		});
	</script>
</body>
</html>
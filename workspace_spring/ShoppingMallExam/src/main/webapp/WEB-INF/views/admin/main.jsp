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
<%@ include file="include/head.jsp"%>
</head>
<body>
<%@ include file="include/top.jsp"%>
<div class="container-fluid">
	<div class="row">
		<jsp:include page="include/sidebar.jsp" flush="false"/>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<table class="table table-bordered" id="dataTable">
					<thead>
						<tr>
							<th>오늘주문</th>
							<th>오늘매출</th>
							<th>상품문의</th>
							<th>1:1문의</th>
							<th>신규회원</th>
							<th>오늘 방문자</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>주문완료 건수</td>
							<td rowspan="2">매출건수</td>
							<td rowspan="2">상품문의건수</td>
							<td rowspan="2">1:1문의건수</td>
							<td rowspan="2">가입건수</td>
							<td rowspan="2">방문자수</td>
						</tr>
						<tr>
							<td>취소완료 건수</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="row">
				<div class="row" id="table_title">
					<div class="col-sm-6">
						쇼핑몰 운영 현황
					</div>
					<div class="col-sm-3">
						
					</div>
					<div class="dropdown col-sm-3">
						<a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="#">
							<span id="selected"></span><span class="caret"></span></a>
						<ul class="dropdown-menu">
						</ul>
					</div>
				
				</div>
			<div class="row">
				<table class="table">
					<thead>
						<tr id="thead1">
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>매출액 (단위:원)</td>
							<%-- 
							<c:forEach items="" var="">
							<td>해당일 불러오기</td>
							</c:forEach>
							--%>
						</tr>
						<tr>
							<td>매결제완료 (단위:건)</td>
							<%-- 
							<c:forEach items="" var="">
							<td>해당일 불러오기</td>
							</c:forEach>
							--%>
						</tr>
						<tr>
							<td>배송준비</td>
							<%-- 
							<c:forEach items="" var="">
							<td>해당일 불러오기</td>
							</c:forEach>
							--%>
						</tr>
						<tr>
							<td>배송중</td>
							<%-- 
							<c:forEach items="" var="">
							<td>해당일 불러오기</td>
							</c:forEach>
							--%>
						</tr>
						<tr>
							<td>배송완료</td>
							<%-- 
							<c:forEach items="" var="">
							<td>해당일 불러오기</td>
							</c:forEach>
							--%>
						</tr>
							<tr>
							<td>구매확정</td>
							<%-- 
							<c:forEach items="" var="">
							<td>해당일 불러오기</td>
							</c:forEach>
							--%>
						</tr>
						<tr>
						<td>취소,환불,교환</td>
						<%-- 
						<c:forEach items="" var="">
						<td>해당일 불러오기</td>
						</c:forEach>
						--%>
					</tr>
						<tr>
						<td>상품후기</td>
						<%-- 
						<c:forEach items="" var="">
						<td>해당일 불러오기</td>
						</c:forEach>
						--%>
					</tr>
				</tbody>
					</table>
			
				</div>
				<div class="row">
					<div class="col-sm-6">
						<table>
							<thead>
								<tr>
									<th class="col-sm-11">기능 업데이트</th>
									<th class="col-sm-1">+</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>불러오기</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-sm-6">
						<table>
							<thead>
								<tr>
									<th class="col-sm-11">공지사항</th>
									<th class="col-sm-1">+</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>불러오기</td>
								</tr>
							</tbody>
						</table>			
					</div>
				</div>
				<div class="row">
				<br><br>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<table>
							<thead>
								<tr>
									<th class="col-sm-11">상품문의</th>
									<th class="col-sm-1">+</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>불러오기</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-sm-6">
						<table>
							<thead>
								<tr>
									<th class="col-sm-11">1:1문의</th>
									<th class="col-sm-1">+</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>불러오기</td>
								</tr>
							</tbody>
						</table>			
					</div>
				</div>
			</div>	
		</div>
	</div>
	


</div>

	<script type="text/javascript">

	$(document).ready(function(){
		var thisWeek = [];
		var currentDay = new Date();
		
	for(var j=0; j<5; j++){		
		var baseDay = currentDay.getDate(); 
		
		var theYear = currentDay.getFullYear();
		var theMonth = currentDay.getMonth();
		var theDate  = currentDay.getDate();
		var theDayOfWeek = currentDay.getDay();
		currentDay.setDate(baseDay - 7); 

		
			for(var i=0; i<7; i++) {
	  			var resultDay = new Date(theYear, theMonth, theDate + (i - theDayOfWeek));
	  			var yyyy = resultDay.getFullYear();
	  			var mm = Number(resultDay.getMonth()) + 1;
	  			var dd = resultDay.getDate();
	 
	  			mm = String(mm).length === 1 ? '0' + mm : mm;
	  			dd = String(dd).length === 1 ? '0' + dd : dd;
	 
	  			thisWeek[i+7*j] = yyyy + '-' + mm + '-' + dd;
			}		
	}
	tableHead(0);
	$('#selected').append(thisWeek[0]+'~'+thisWeek[6]);
	for(var i = 0; i < 5; i++){
		$('.dropdown-menu').append('<li><a href="'+i+'">'+thisWeek[7*i]+'~'+thisWeek[7*i+6]+'</a></li>');
	}
	$('.dropdown-toggle').dropdown()
	$('.dropdown-menu a').click(function(){
		event.preventDefault();
	    $('#selected').text($(this).text());
		tableHead($(this).attr('href'));
	   
	  });
	function tableHead(nWeek){
		$('#thead1').empty();
		$('#thead1').append('<th>설정</th>');
		for(var i = nWeek*7; i < nWeek*7+7; i++){
			$('#thead1').append('<th>'+thisWeek[i].substring(5,7)+'/'+thisWeek[i].substring(8)+'</th>');	
		}
		$('#thead1').append('<th>이번주 합계</th>');
	}
	
	});

	 
	
	
	
	</script>
</body>
</html>
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
	<script src="/resources/js/uploadfn.js" type="text/javascript"></script>
<title>Insert title here</title>
<style type="text/css">
.div_search_option_outter {
	border : solid 1px black;
	
}
.div_search_option_inner {
	border-bottom : solid 1px black;
}
.div_search_option_inner_left {
	border-bottom : solid 1px black;
	border-right : solid 1px black;
	background-color: lightgray;
}
ul li {
	list-style:none;
}
.product_search_result_top {
	border-bottom: solid 1px gray;
	border-top: solid 1px gray;
	background-color: lightgray;
}
.li_product_search_result {
	border-right : solid 1px gray;
 
}
input[type=checkbox] {
	margin: 0px;
}
.div_search_option_result_inner {
	border-bottom : solid 1px gray;
}
.color_black:link {
	color : black;
}
.color_black:visited {
	color : black;
 }
.color_black:active {
 	color : black;
 }
.color_black:hover {
 	color : black;
 }
 .link_product_category_select {
 	font-size: 5px;
 	font-style: italic;
 }
 img {
 	height: 100%; 
 	width: 100%; 
 	object-fit: contain; 
 	float: right;
 }
</style>
<%@ include file="../include/head.jsp"%>
</head>
<body>
<%@ include file="../include/top.jsp"%>
<div class="container-fluid">
	<div class="row">
				<jsp:include page="../include/sidebar.jsp" flush="false"/>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-9">
					<h1>판매상품관리</h1>
				</div>
				<div class="col-sm-3">
					<button class="btn btn-primary" id="btn_product_insert" style="float:right">상품 등록</button>
				</div>
			</div>
			<div class="row div_search_option_outter">
				<form action="/admin/product/search" method="post" id="form_product_search">
				<div id="div_product_category">
					<div class="col-sm-2 div_search_option_inner_left div_product_category">
						카테고리
					</div>
					<div class="col-sm-10 div_search_option_inner div_product_category">
						<div class="row">
							<ul class="col-sm-4">
								<li>1차 카테고리</li>
							</ul>
							<ul class="col-sm-4">
								<li>2차 카테고리</li>
							</ul>
							<ul class="col-sm-4">
								<li>3차 카테고리</li>
							</ul>
							<ul id="ul_product_category_1" class="col-sm-4">
								<li>1차 db불러오기</li>
							</ul>
							<ul id="ul_product_category_2" class="col-sm-4">
								<li>2차 db불러오기</li>
							</ul>
							<ul id="ul_product_category_3" class="col-sm-4">
								<li>3차 db불러오기</li>
							</ul>
						</div>
					</div>
				</div>
				<div id= "div_product_regDate">
					<div class="col-sm-2 div_search_option_inner_left div_product_regDate">
						기간
					</div>
					<div class="col-sm-10 div_search_option_inner div_product_regDate">
						<div class="row">
	
						<input type="date" id="date1" name="regDate" value="${aWeekAgo }">~<input type="date" id="date2" name="regDate" value="${today }">
						<select  onchange="selectDate(this.value)">
							<option value="${aWeekAgo }" selected>1주전</option>
							<option value="${aMonthAgo }" >1달전</option>
							<option value="${threeMonthsAgo }" >3달전</option>
						</select>
		
						</div>						
					</div>
				</div>
				<div id="div_product_price">
					<div class="col-sm-2 div_search_option_inner_left div_product_price">
						가격
					</div>
					<div class="col-sm-10 div_search_option_inner div_product_price">
						<div class="row">
							<input id="minPrice" name="minPrice">원 ~ <input id="maxPrice" name="maxPrice">원
						</div>
					</div>
				</div>
				<div id="div_product_sellStatus">
					<div class="col-sm-2 div_search_option_inner_left div_product_sellStatus">
						판매상태
					</div>
					<div class="col-sm-10 div_search_option_inner div_product_sellStatus">
						<div class="row">
							<input type="checkbox" name="sellStatus" value="0" class="input_sellStatus">판매대기
							<input type="checkbox" name="sellStatus" value="1" class="input_sellStatus">판매중
							<input type="checkbox" name="sellStatus" value="2" class="input_sellStatus">품절
							<input type="checkbox" id="sellStatus_select_all">전체 선택
						</div>
					</div>
				</div>
				<div id="div_product_isDelete">
					<div class="col-sm-2 div_search_option_inner_left div_product_isDelete">
						전시상태
					</div>
					<div class="col-sm-10 div_search_option_inner div_product_isDelete">
						<div class="row">
							<input type="checkbox" name="isDelete" value="0" class="input_isDelete">전시
							<input type="checkbox" name="isDelete" value="1" class="input_isDelete">미전시
							<input type="checkbox" id="isDelete_select_all">전체 선택
						</div>
					</div>
				</div>
				<div id="div_product_searchKeyword">
					<div class="col-sm-2 div_search_option_inner_left div_product_searchKeyword">
						검색어
					</div>
					<div class="col-sm-10 div_search_option_inner div_product_searchKeyword">
						<div class="row">
							<select name="searchType" id="searchType">
								<option value="productName">상품명</option>
								<option value="productNo">상품번호</option>
								<option value="productSet">세트</option>
							</select>
							<input name="keyWord" id="keyWord">
						</div>
					</div>
				</div>
				<div id="div_product_category_select"></div>
				</form>
				
				<div style="text-align:center" class="div_product_search">
					<button class="btn btn-primary" id="btn_product_search">검색</button>
				</div>
			</div>
			<div class="row">
				<br><br>
				몇개/정렬순서/몇개출력/엑셀업다운?
				<br><br>
			</div>
			<div class="row">
				<div class="product_search_result">
					<div class="row product_search_result_top">
						<ul>
							<li class="col-sm-1">
								<input type="checkbox" id="checkAll">
							</li>
							<li class="col-sm-2">
								카테고리 | 카테고리번호
							</li>
							<li class="col-sm-1">
								상품번호
							</li>
							<li class="col-sm-2">
								상품명
							</li>
							<li class="col-sm-1">
								판매가(할인율%)
							</li>
							<li class="col-sm-1">
								재고
							</li>
							<li class="col-sm-1">
								등록일
							</li>
							<li class="col-sm-1">
								판매상태
							</li>
							<li class="col-sm-1">
								전시상태
							</li>
							<li class="col-sm-1">
								관리
							</li>
						</ul>
					</div>
					<form action="/admin/product/list_delete" method="post" id="form_product_search_result_list">
						<c:forEach items="${productList }" var="dto" begin="1" varStatus="vs">
							<div class="row div_search_option_result_inner">
								<ul class="ul_product_search_result">
									<li class="col-sm-1 li_product_search_result">
										<input type="checkbox" class="checkbox_product" name="checkbox_product" value="${dto.productNo }">
									</li>
									<li class="col-sm-2 li_product_search_result">
										${dto.categoryName } | ${dto.categoryNo }
									</li>
									<li class="col-sm-1 li_product_search_result">
										${dto.productNo}
									</li>
									<li class="col-sm-2 li_product_search_result">
										<div class="row">
											<div class="col-sm-4 productThumbnail">
												<c:if test="${not empty dto.files[0] }">
													<img class="getImage" src="/displayfile?filename=${dto.files[0] }" data-productNo="${dto.productNo}"/>	
												</c:if>
											</div>
											<div class="col-sm-8">
												${dto.productName}
											</div>
										</div>
									</li>
									<li class="col-sm-1 li_product_search_result">
										${dto.productDiscountPrice}(${dto.productDiscountRate }%)
									</li>
									<li class="col-sm-1 li_product_search_result">
										${dto.productTotalQuantity}
									</li>
									<li class="col-sm-1 li_product_search_result">
										${dto.regDate }
									</li>
									<li class="col-sm-1 li_product_search_result li_product_search_sellStatus">
										<select name="sellStatus" class="select_product_search_sellStatus" >
											<option value="0"
												<c:if test="${dto.sellStatus eq 0}">
													selected="selected"
												</c:if>
												>판매대기
											</option>
											<option value="1"
												<c:if test="${dto.sellStatus eq 1}">
													selected="selected"
												</c:if>
												>판매중
											</option>
										<option value="2"
											<c:if test="${dto.sellStatus eq 2}">
												selected="selected"
											</c:if>
											>품절
										</option>
										</select>								
									</li>
									<li class="col-sm-1 li_product_search_result li_product_search_isDelete">
										<select name="isDelete" class="select_product_search_isDelete" >
										<option value="0"
											<c:if test="${dto.isDelete eq 0}">
												selected="selected"
											</c:if>
											>전시
										</option>
										<option value="1"
											<c:if test="${dto.isDelete eq 1}">
												selected="selected"
											</c:if>
											>미전시
										</option>
										</select>	
									</li>
									<li class="col-sm-1">
										<button class="btn btn-primary btn_product_update" data-location="${dto.productNo}">수정</button>			
									</li>
								</ul>
							</div>
						</c:forEach>
					</form>			
				</div>
				<div class="row">				
					<button class="btn btn-danger" id="btn_product_checked_delete" style="float:left">삭제</button>
					<button class="btn btn-danger" id="btn_product_checked_update" style="float:right">수정사항 저장</button>
				</div>
				
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>

<script type="text/javascript">
		var StringBuffer = function() { 
			this.buffer = new Array(); 
		}; 
		StringBuffer.prototype.append = function(str) { 
			this.buffer[this.buffer.length] = str; 
		}; 
		StringBuffer.prototype.toString = function() { 
			return this.buffer.join(""); 
		};

		$(document).ready(function(){
		
		getCategoryList();

		equalHeights( $("#div_product_category"));
		equalHeights( $("#div_product_regDate"));
		equalHeights( $("#div_product_price"));
		equalHeights( $("#div_product_sellStatus"));
		equalHeights( $("#div_product_isDelete"));
		equalHeights( $("#div_product_searchKeyword"));

		$('div').on("click","#btn_product_insert",function(event){
			event.preventDefault();
			location.assign("/admin/product/insert");
		});
		$('.product_search_result').on("click", "#checkAll", function(){
		    if (!$('#checkAll').prop('checked')) {
		            $('.checkbox_product').prop('checked', false);
		    }else{
		        $('.checkbox_product').prop('checked', true);
		    }
		});
		$('.product_search_result').on("click", ".checkbox_product", function(){
		    $("#checkAll").prop('checked', false);
		});
		  
		$('.div_product_isDelete').on("click", "#isDelete_select_all", function(){
		    if (!$('#isDelete_select_all').prop('checked')) {
		            $('.input_isDelete').prop('checked', false);
		    }else{
		        $('.input_isDelete').prop('checked', true);
		    }
		});
		$('.div_product_isDelete').on("click", ".input_isDelete", function(){
		    $("#sellStatus_select_all").prop('checked', false);
		});

		
		$('.div_product_sellStatus').on("click", "#sellStatus_select_all", function(){
		    if (!$('#sellStatus_select_all').prop('checked')) {
		            $('.input_sellStatus').prop('checked', false);
		    }else{
		        $('.input_sellStatus').prop('checked', true);
		    }
		});
		$('.div_product_sellStatus').on("click", ".input_sellStatus", function(){
		    $("#sellStatus_select_all").prop('checked', false);
		});

		$('.product_search_result').on("click",".btn_product_update",function(event){
			event.preventDefault();
			var that = $(this);

			location.assign("/admin/product/update/"+that.attr("data-location"));
			
		});
		$('div').on("click","#btn_product_checked_delete",function(event){
			event.preventDefault();
			
			$("#form_product_search_result_list").submit();			
		});
		$("#btn_product_checked_update").click(function(event){
			event.preventDefault();
			
			var checkedArr = new Array();
			

			$("input:checkbox[name=checkbox_product]:checked").each(function(){
				var checkedProductNo = this.value;
				var checkedSellStatus = $(this).parent().parent().children(".li_product_search_sellStatus").children(".select_product_search_sellStatus").children("option:selected").val();
				var checkedIsDelete = $(this).parent().parent().children(".li_product_search_isDelete").children(".select_product_search_isDelete").children("option:selected").val();
				var productDTO={
					productNo : checkedProductNo,
					sellStatus : checkedSellStatus,
					isDelete : checkedIsDelete
						};
				checkedArr.push(productDTO);
				
			});
			$.ajax({
				type : 'post',
				url : '/product_checked_update',
				data : {
					checkedArr : JSON.stringify(checkedArr) 	
				},
				success : function(){
					location.assign("/admin/product/list");
				}
			});
			
			
			
		});
	
		
		$(".div_product_category").on("click", ".link_product_category", function(event){
			event.preventDefault();
			var that = $(this);
			var str = new StringBuffer();
			var degree = Number($(this).attr("data-degree"))+1;
			var id = "#ul_product_category_"+degree;
			var nextId = "#ul_product_category_"+(degree+1);
				$.ajax({
					type : 'get',
					url : '/product_CategoryN',
					dataType : 'text',
					data : {
						categoryNoRef : that.attr("href"),
						categoryDegree : that.attr("data-degree")
					},
					success : function(data){
						var list = $.parseJSON(data);
						var listLen = list.length;
						for(var i = 0; i < listLen; i++){
							str.append('<li><a href="'+list[i].categoryNo+'" class="link_product_category color_black" data-degree="'+list[i].categoryDegree+'" data-name="'+list[i].categoryName+'">');
							str.append(list[i].categoryName+'</a>');
							str.append('<a href="'+list[i].categoryNo+'" class="linkt_product_category_select color_black">선택</a></li>');
						}
						var resultstr = str.toString();
						
						$(id).html(resultstr);
						$(nextId).html("");
						childHeights( $(".div_search_option_inner.div_product_category"));	
					}
				});
				
			
		});

	
		<%--수정할 부분--%>
		$(".div_product_category").on("click", ".linkt_product_category_select", function(event){
			event.preventDefault();
			
			$("#div_product_category_select").html("<input type='hidden' name='categoryNo' class='input_categoryNo' value='"+$(this).attr("href")+"'>");

			
		});
		$(".div_product_search").on("click","#btn_product_search", function(event){
			event.preventDefault();
			var check = false;
			var sellStatus = document.getElementsByName("sellStatus");
			var isDelete = document.getElementsByName("isDelete"); 
			for(var i = 0 ; i < sellStatus.length; i++){
				if(sellStatus[i].checked){
					check = true;
					break;
				}
			}
			if(!check){
				alert("판매상태 체크박스를 선택하시오.");
				return false;
			}
			check = false;
			for(var i = 0 ; i < isDelete.length; i++){
				if(isDelete[i].checked){
					check = true;
					break;
				}
			}
			if(!check){
				alert("전시상태 체크박스를 선택하시오.");
				return false;
			}
			if($("#minPrice").val()==""){
				$("#minPrice").remove();
			}
			if($("#maxPrice").val()==""){
				$("#maxPrice").remove();
			}
			$("#form_product_search").submit();
		});

		
	});

	function childHeights(that){
	   
		var height = that.children('div').height();
		that.prev().height(height);
	    that.height(height);
	}
	function equalHeights(parent){
	    var highest = 0;
		var children = parent.children();
	    children.each(function() {

	        var thisHeight = $(this).height();
			if(thisHeight > highest) {
				highest = thisHeight;
	        }
			thisHeight = $(this).children().height();

			if(thisHeight > highest) {
				highest = thisHeight;
	        }
		});
	  
	    children.height(highest);
	}

	function getAttach(productNo){
		var str;
		
		$.ajax({
			type : 'get',
			url : '/getAttach/'+productNo,
			dataType : 'text',
			async: false,
			data : {
			},
			success : function(data){
				var list = $.parseJSON(data);
				if(list[0]!=null)str = list[0];
			}
		});
		
		return str;	
	}
	

	function getCategoryList(){
		var str = '';			
		$.getJSON("/product_Category", function(data){
			for(var i = 0 ; i < data.length ; i++){
				str += '<li><a href="'+data[i]["categoryNo"]+'" class="link_product_category color_black" data-degree="'+data[i]["categoryDegree"]+'">'+data[i]["categoryName"]+'</a><a href="'+data[i]["categoryNo"]+'" class="linkt_product_category_select color_black">선택</a></li>';
			}
			$("#ul_product_category_1").html(str);
			childHeights( $(".div_search_option_inner.div_product_category"));
		});
	
	};
	function selectDate(option){
		var date1= document.getElementById('date1');
		
		date1.setAttribute("value",option);
	}


</script>
</body>
</html>
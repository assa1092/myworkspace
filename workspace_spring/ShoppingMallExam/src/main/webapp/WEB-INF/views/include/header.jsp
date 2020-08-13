<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="/resources/css/mainIndex.css">
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/notosanskr.css">
<link rel="stylesheet" href="//fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&amp;display=swap">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>페쓰으루우움</title>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var doc_h = $('body').height() - 395; //상하단 만큼빼줌
						$('#contents').css({
							'min-height' : doc_h
						});

<<<<<<< HEAD
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row topheader">
			<div class="col-sm-2 dropdown">
				<button class="btn btn-blue dropdown-toggle" type="button" data-toggle="dropdown" data-hover="dropdown">
					SEND YOUR LOVE TO PETS<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">KAKAO Chat</a></li>
					<li><a href="/customerservice/faq">FAQs</a></li>
					<li><a href="/customerservice/qna">Q&A</a></li>
					<li><a href="#">Membership(comming soon)</a></li>
				</ul>
			</div>
			<div class="col-sm-8"> 1644-9603 ( MON - FRI 9:30 - 17:00, lunch 11:50 - 13:00 )</div>
			<div class="col-sm-2">"Pets, Just Enjoy The Bathroom!</div>
		 </div>
	</div>
	<div class="container">
		<div class="row">
			<div class="row col-sm-1">
				홈버튼
			</div>
			<div class="row col-sm-11">
				<div class="row">
					<div class="col-sm-8">
					
						<div class="col-sm-2"></div>
						<div class="col-sm-2"></div>
						<div class="col-sm-2"></div>
						<div class="col-sm-2"></div>
						<div class="col-sm-2"></div>
					</div>
					<div class="col-sm-4">
					<c:choose>
					<c:when test="${sessionScope.memberId == null}">
					<a href="${path}/member/login.do"><div class="col-sm-3">로그인</div></a>
                    </c:when>
                    <c:otherwise>
                        ${sessionScope.memberName}님이 로그인중입니다.
                        <a href="${path}/member/logout.do"><div class="col-sm-3">로그아웃</div></a>
                    </c:otherwise>
                    </c:choose>
						<div class="col-sm-3"><a href="/member/insert">회원가입</a></div>
						<div class="col-sm-3">마이페이지</div>
						<div class="col-sm-3">주문관리</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						
						<div class="col-sm-2">ABOUT</div>
						<div class="col-sm-2">PRODUCT</div>
						<div class="col-sm-2"><a href="/review/main">REVIEW</a></div>
						<div class="col-sm-2"><a href="/customerservice/main">C/S CENTER</a></div>
						<div class="col-sm-2"><a href="/customerservice/inquiry">INQUIRY</a></div>
						<div class="col-sm-2"><a href="/member/list">회원관리</a></div>
					</div>
					<div class="col-sm-4">
							<div class="col-sm-7">
								<input name="searchproductname">
							</div>
							<div class="col-sm-2">
								<button type="button" class="btn-none">검색</button>
							</div>
							<div class="col-sm-1">바구니</div>
							<div class="col-sm-1">목록</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
=======
						/*header*/
						$('.headerMenu .header #nav li')
								.mouseover(
										function() {
											var navHt = $(
													'.headerMenu .header #nav li')
													.outerHeight() - 1;
											var gnbHt = $(this).find(
													'.navbarMenu').outerHeight();
											$('.headerMenu .header #nav .navbarMenu').css({
														'top' : navHt
													});
											$('.backgroundCover').css({
												'height' : gnbHt
											});
>>>>>>> fetch_head

											if ($(this).children('.navbarMenu').length > 0) {
												$(this).find('.pageOne').addClass(
														'active');
												$('.backgroundCover').stop().show();
												$(this).children('.navbarMenu')
														.stop().show();
											}
										})
								.mouseout(
										function() {
											$(this).find('.pageOne').removeClass(
													'active');
											$('.backgroundCover').stop().hide();
											$('.headerMenu .header #nav li .navbarMenu')
													.stop().hide();
										});

						$('#icoHam').click(function() {
							$("#navPrdList").show();
							$('.backgroundCover').stop().show();
						});

						//top_header fixed
						var hdHt = $('.top_header').outerHeight();
						$(window).scroll(function() {
							var winTop = $(window).scrollTop();
							if (winTop >= hdHt) {
								$('.top_header').addClass('fixed');
								$('.top_header').siblings('.header_color').css({
									'padding-top' : hdHt
								});
							} else {
								$('.top_header').removeClass('fixed');
								$('.top_header').siblings('.header_color').css({
									'padding-top' : '0'
								});
							}
						});

						//fixed_btn ( top_btn )
						$(window).scroll(function() {
							var winTop = $(window).scrollTop();
							if (winTop >= 400) {
								$('.btnTop').addClass('on');
							} else {
								$('.btnTop').removeClass('on');
							}
						});

						//btnTop ( top_btn )
						$('.btnTop').click(function(event) {
							event.preventDefault();
							$('html,body').animate({
								scrollTop : 0
							}, 500, 'linear');
							return false;
						});

					});
</script>
</head>
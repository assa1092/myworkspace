<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- top_header 시작  -->
<div class="top_header">

	<!-- SEND YOUR LOVE TO PETS 고정메뉴 시작  -->
	<div class="topFixed">
		<div class="topTitle">
			<a href="#" class="send">SEND YOUR LOVE TO PETS</a>
			<div class="sendHoverList">
				<ul class="hoverList">
					<li><a onclick="javascript:window.open('https://lc1.lunasoft.co.kr/lunachat/api-connect/@페스룸/main', 'lunachat', 'width=1024, height=800');" style="cursor: pointer">KAKAO Chat</a></li>
					<li><a href="#">FAQs</a></li>
					<li><a href="#">Q&amp;A</a></li>
					<li><a href="#">MEMBERSHIP<span>(Coming soon)</span></a></li>
				</ul>
				<div class="arrow">
					<img src="https://www.pethroom.com/web/upload/images/topBan_ar.png" alt="">
				</div>
			</div>
		</div>
		<div class="telInfomation">
			<img src="https://www.pethroom.com/web/upload/images/mobile/ico_tel.png" alt=""> 1644-9603 ( MON - FRI 9:30 - 17:00, lunch 11:50 - 13:00 )
		</div>
		<div class="slogan">"Pets, Just Enjoy The Bathroom!"</div>
	</div>
	<!-- SEND YOUR LOVE TO PETS 고정메뉴 끝 -->

	<!-- 전체 메뉴 시작 -->
	<div class="headerMenu">
		<div class="joinList">
			<ul>
				<li class="xans-element- xans-layout xans-layout-statelogoff "><a href="/member/login.do">로그인</a></li>
				<li class="xans-element- xans-layout xans-layout-statelogoff "><a href="/member/insert">회원가입</a></li>
				<li><a href="/myshop/index.html">마이페이지</a></li>
				<li><a href="/myshop/order/list.html">주문관리</a></li>
			</ul>
		</div>

		<!-- header 시작 -->
		<div class="header">
			<div class="logo">
				<a href="/"><img src="https://www.pethroom.com/web/upload/category/editor/2020/01/02/768b248922ce8fe4d74a541c074f7dd7.png" alt=""></a>
			</div>

			<!-- 검색&카트 시작  -->
			<div class="searchAndCart">
				<div class="searchBody">
					<form id="searchBarForm" name="" action="/product/search.html" method="get" target="_self" enctype="multipart/form-data">
						<input id="banner_action" name="banner_action" value="" type="hidden" /> <span class="xans-element- xans-layout xans-layout-searchheader"><input id="keyword" name="keyword" fw-filter="" fw-label="검색어" fw-msg="" class="inputTypeText" placeholder="" onmousedown="SEARCH_BANNER.clickSearchForm(this)" value="" type="text" /> <img src="https://www.pethroom.com/web/upload/images/ico_zoom.png" alt="" onclick="SEARCH_BANNER.submitSearchBanner(this); return false;"> </span>
					</form>
					<a href="/order/basket.html" class="xans-element- xans-layout xans-layout-orderbasketcount cartBtn "> <img src="https://www.pethroom.com/web/upload/images/ico_cart.png" alt=""><span class="cart_num" data-cartnum="0">0</span></a> <a href="#" id="icoHam"><img src="https://www.pethroom.com/web/upload/images/ico_hamp.png" alt="" class="icoHam"></a>
				</div>
			</div>
			<!-- 검색&카트 끝 -->

			<div class="navbar">
				<ul id="nav">
	<!-- ABOUT --><li><a href="#" class="pageOne">ABOUT</a>
						<div class="navbarMenu">
							<div class="navbarMenuTitle">
								<h2><a href="#">ABOUT</a></h2>
								<ul class="subNavList">
									<li><a href="/about/philosophy">PHILOSOPHY</a></li>
									<li><a href="/about/socialActivity">SOCIAL ACTIVITY</a></li>
									<li><a href="/about/global">GLOBAL</a></li>
									<li><a href="/about/roommate">ROOMMATE</a></li>
									<li><a href="/about/partners">PARTNERS</a></li>
									<li><a href="/about/people">PEOPLE</a></li>
								</ul>
							</div>
							<!--navbarMenuTitle-->
							<div class="wideNavMenu">
								<h2><a href="#">OUR BRANDS</a></h2>
								<ul class="subNavList">
									<li><a href="#">BOSS AND ALEX</a></li>
								</ul>
								<div class="navBanner">
									<a href="https://www.pethroom.com/product/take-care-set/109/category/46/display/1/"><img src="https://www.pethroom.com/web/upload/images/navBanner_05.png" alt="" class="btLine"></a>
								</div>
							</div>
		<!-- ABOUT --></div></li>
						
	<!-- PRODUCT --><li><a href="/product/main" class="pageOne">PRODUCT</a>
						<div class="navbarMenu " id="navPrdList">
							<div class="navbarMenuTitle">
								<h2><a href="/product/allProduct"><span style="color: #113f89; background: #ffc303;">한눈에 모아보기</span></a></h2>
								<h2><a href="#">MY PET</a></h2>
								<ul class="subNavList">
									<li><a href="#">FOR DOG</a></li>
									<li><a href="#">FOR CAT</a></li>
								</ul>
								<h2><a href="/product/all">ALL PRODUCTS</a></h2>
								<h2><a href="#">BEST &amp; STEADY <span class="newicon">N</span></a></h2>
								<h2><a href="#">NEW PRODUCT <span class="newicon">N</span></a></h2>
								<h2><a href="#">SPECIAL SET</a></h2>
							</div>
							<div class="midMenu">
								<h2><a href="#">목욕/미용 용품</a></h2>
								<ul class="subNavList">
									<li><a href="#">Relax Shower<span class="kr">릴렉스 샤워 (샤워기)</span></a></li>
									<li><a href="#">Healing Brush <span class="kr">힐링 브러쉬 (죽은털제거 빗)</span></a></li>
									<li><a href="#">Sponge Towel<span class="kr">스펀지 타올</span></a></li>
									<li><a href="#">Bubble Shampoo<span class="kr">버블 샴푸</span></a></li>
									<li><a href="#">Deep Clean Bath Bomb<span class="kr">딥클린 배쓰 밤 (입욕제)</span></a></li>
									<li><a href="#">Magic Glove<span class="kr">매직 글러브</span></a></li>
									<li><a href="#">Dry Jacket<span class="kr">드라이 자켓</span></a></li>
								</ul>
								<h2><a href="#">배변용품</a></h2>
								<ul class="subNavList mb0">
									<li><a href="/product/detail.html?product_no=18">Dust Free Bentonite<span class="kr">더스트 프리 벤토나이트 (먼지없는 벤토모래)</span></a></li>
									<li><a href="/product/detail.html?product_no=17">Odour Free Tofu<span class="kr">오도어 프리 두부 (악취없는 두부모래)</span></a></li>
									<li><a href="/product/detail.html?product_no=36">Clean-Up Mat <span class="kr">클린-업 매트 (사막화 막는 매트)</span></a></li>
								</ul>
							</div>
							<div class="midMenu">
								<h2><a href="/product/list.html?cate_no=115">야외/관리 용품</a></h2>
								<ul class="subNavList">
									<li><a href="/product/list.html?cate_no=102">Paw Care Essence<span class="kr">포우 케어 에센스 (발 보습제)</span></a></li>
									<li><a href="/product/list.html?cate_no=95">Nature Ear Cleaner<span class="kr">네이처 이어 클리너 (귀 세정제)</span></a></li>
									<li><a href="/product/list.html?cate_no=82">Comfort-X Harness<span class="kr">컴포트 X 하네스 (하네스: 몸통)</span></a></li>
									<li><a href="/product/list.html?cate_no=83">Comfort Leash<span class="kr">컴포트 리쉬 (리드줄)</span></a></li>
									<li><a href="/product/list.html?cate_no=106">Happy Cat Spray &amp; Powder<span class="kr">해피캣 스프레이/파우더</span></a></li>
								</ul>
								<h2><a href="/product/list.html?cate_no=117">위생용품</a></h2>
								<ul class="subNavList mb0">
									<li><a href="/product/list.html?cate_no=57">Pet-Doctor Spray Plus+<span class="kr">펫-닥터 스프레이 플러스+(살균소취제)</span></a></li>
									<li><a href="/product/list.html?cate_no=122">Dental Clean Toothpaste<span class="kr">덴탈 클린 치약</span></a></li>
								</ul>
							</div>
		<!-- PRODUCT --></div></li>
						
	<!-- REVIEW --><li><a href="/review/main" class="pageOne">REVIEW</a>
						<div class="navbarMenu">
							<div class="navbarMenuTitle">
								<h2><a href="#none">REVIEW</a></h2>
								<ul class="subNavList">
									<li><a href="/review/best">BEST REVIEW</a></li>
									<li><a href="/review/all">ALL REVIEW</a></li>
								</ul>
							</div>
							<div class="wideNavMenu">
								<h2><a href="#">REVIEW EVENT</a></h2>
								<ul class="subNavList">
									<li><a>매달 베스트 포토리뷰 5명에게 5만원 상당의 페스룸 제품을 드립니다.</a></li>
								</ul>
								<div class="navBanner">
									<a href="#"><img src="http://pepem1.cafe24.com/web/upload/images/navBanner_06.png" alt=""></a>
								</div>
							</div>
		<!-- REVIEW --></div></li>
						
<!-- C/S CENTER --><li><a href="/customerservice/main" class="pageOne">C/S CENTER</a>
						<div class="navbarMenu">
							<div class="navbarMenuTitle">
								<h2><a href="#">C/S CENTER</a></h2>
								<ul class="subNavList">
									<li><a href="/customerservice/notice">NOTICE</a></li>
									<li><a href="/customerservice/qna">Q&amp;A</a></li>
									<li><a href="/customerservice/faq">FAQ</a></li>
									<li><a href="/customerservice/event">EVENT</a></li>
								</ul>
							</div>
							<div class="wideNavMenu">
								<h2><a href="#">SEND YOUR LOVE TO PETS</a></h2>
								<ul class="subNavList">
									<li><a>PETHROOM은 여러분들과 반려동물의 행복한 일상을 만들기 위해 최선을 다하고 있습니다.</a></li>
								</ul>
								<div class="navBanner">
									<a href="#"><img src="https://www.pethroom.com/web/upload/images/navBanner_03.png" alt="" class="btLine"></a>
								</div>
							</div>
	<!-- C/S CENTER --></div></li>

	<!-- INQUIRY --><li><a href="/inquiry" class="pageOne">INQUIRY</a></li>
				</ul>
			</div>
		</div><!-- header 끝 -->
	</div><!-- 전체 메뉴 끝 -->
	
	<div class="backgroundCover"></div>
	
</div><!-- top_header 끝 -->
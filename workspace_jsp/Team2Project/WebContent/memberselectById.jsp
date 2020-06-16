<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Insert title here</title>
<style>
body {
	color: #6F8BA4;
	margin-top: 20px;
}

.section {
	padding: 100px 0;
	position: relative;
}

.gray-bg {
	background-color: #f5f5f5;
}

img {
	max-width: 100%;
}

img {
	vertical-align: middle;
	border-style: none;
}
/* About Me 
---------------------*/
.about-text h3 {
	font-size: 45px;
	font-weight: 700;
	margin: 0 0 6px;
}

@media ( max-width : 767px) {
	.about-text h3 {
		font-size: 35px;
	}
}

.about-text h6 {
	font-weight: 600;
	margin-bottom: 15px;
}

@media ( max-width : 767px) {
	.about-text h6 {
		font-size: 18px;
	}
}

.about-text p {
	font-size: 18px;
	max-width: 450px;
}

.about-text p mark {
	font-weight: 600;
	color: #20247b;
}

.about-list {
	padding-top: 10px;
}

.about-list .media {
	padding: 5px 0;
}

.about-list label {
	color: #20247b;
	font-weight: 600;
	width: 88px;
	margin: 0;
	position: relative;
}

.about-list label:after {
	content: "";
	position: absolute;
	top: 0;
	bottom: 0;
	right: 11px;
	width: 1px;
	height: 12px;
	background: #20247b;
	-moz-transform: rotate(15deg);
	-o-transform: rotate(15deg);
	-ms-transform: rotate(15deg);
	-webkit-transform: rotate(15deg);
	transform: rotate(15deg);
	margin: auto;
	opacity: 0.5;
}

.about-list p {
	margin: 0;
	font-size: 15px;
}

@media ( max-width : 991px) {
	.about-avatar {
		margin-top: 30px;
	}
}

.about-section .counter {
	padding: 22px 20px;
	background: #ffffff;
	border-radius: 10px;
	box-shadow: 0 0 30px rgba(31, 45, 61, 0.125);
}

.about-section .counter .count-data {
	margin-top: 10px;
	margin-bottom: 10px;
}

.about-section .counter .count {
	font-weight: 700;
	color: #20247b;
	margin: 0 0 5px;
}

.about-section .counter p {
	font-weight: 600;
	margin: 0;
}

mark {
	background-image: linear-gradient(rgba(252, 83, 86, 0.6),
		rgba(252, 83, 86, 0.6));
	background-size: 100% 3px;
	background-repeat: no-repeat;
	background-position: 0 bottom;
	background-color: transparent;
	padding: 0;
	color: currentColor;
}

.theme-color {
	color: #fc5356;
}

.dark-color {
	color: #20247b;
}
</style>
</head>
<body>
	<div style="padding: 20px 70px 20px 70px;">
		<jsp:include page="header.jsp" />
		<%-- <h2>회원 정보 자세히 보기</h2>

		ID: ${mDTO.id} <br> 이름: ${mDTO.name} <br>
		<c:if test="${customer }">권한: customer<br>
		</c:if>
		<c:if test="${admin }">권한: admin<br>
		</c:if>
		<c:if test="${manager}">권한: manager<br>
		</c:if>
 --%>

		<!-- 부트스트랩 적용 -->
		<section class="section about-section" id="about">
			<div class="container">
				<div class="row align-items-center flex-row-reverse">
					<div class="col-lg-6">
						<div class="about-text go-to">
							<h3 class="">회원 정보 자세히보기</h3>
							<div class="row about-list">
								<div class="col-md-10">
									<div class="media">
										<label style="font-size: 25px;">아이디 </label>
										<p style="font-size: 25px;">${mDTO.id}</p>
									</div>
									<br>
									<br>
									<div class="media">
										<label style="font-size: 25px;">이름 </label>
										<p style="font-size: 25px;">${mDTO.name}</p>
									</div>
									<br>
									<br>
									<c:if test="${customer }">
										<div class="media">
											<label style="font-size: 25px;">권한 </label>
											<p style="font-size: 25px;">customer</p>
										</div>
									</c:if>
									<c:if test="${manager }">
										<div class="media">
											<label style="font-size: 25px;">권한 </label>
											<p style="font-size: 25px;">manager</p>
										</div>
									</c:if>
									<c:if test="${admin }">
										<div class="media">
											<label style="font-size: 25px;">권한 </label>
											<p style="font-size: 25px;">admin</p>
										</div>
									</c:if>

								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="about-avatar">
							<img src="profile.jpeg" alt="프로필">
						</div>
					</div>
				</div>
				<div style="float: right">
				<button class="btn btn-outline-success"
					onclick="location.href='memberupdateui.do?id=${mDTO.id}'">수정</button>
				<button class="btn btn-outline-success"
					onclick="memberDelete('${mDTO.id}')">탈퇴</button>
				<button class="btn btn-outline-success"
					onclick="location.href='reviewlist.do'">목록</button>


				<script type="text/javascript">
					function memberDelete(id) {
						var isOk = confirm("모든 게시글이 삭제됩니다. 탈퇴하시겠습니까?");
						if (isOk == true) {
							location.href = "memberdelete.do?id=" + id;
						}
					}
				</script>
				</div>
			</div>

		</section>
		<br> <br> <br>
		<jsp:include page="footer.jsp" />
</body>
</html>
<%@page import="kr.co.domain.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Management</title>
<%@ include file="../include/head.jsp"%>
</head>
<body>
	<%@ include file="../include/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="../include/sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">BOARD LIST</h1>
				<div class="row">
					<table id="mytable" class="table table-bordred">
						<thead>
							<tr>
								<th>번호</th>
								<th>게시판명</th>
								<th>게시판아이디</th>
								<th>사용여부</th>
								<th>새글</th>
								<th>총게시글</th>
								<th>게시글관리</th>
								<th>게시글쓰기</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>1</td>
								<td>리뷰</td>
								<td><a href="#">review</a></td>
								<td><span class="glyphicon glyphicon-ok-sign"></span></td>
								<td>새글</td>
								<td>dddd</td>
								<td><button class="btn btn-warning btn-xs" onclick="location.href='reviewBoardList';">
										<span class="glyphicon glyphicon-list-alt"></span>
									</button></td>
								<td><button class="btn btn-success btn-xs" onclick="location.href='reviewBoardWrite';">
										<span class="glyphicon glyphicon-pencil"></span>
									</button></td>
							</tr>

							<tr>
								<td>2</td>
								<td>공지</td>
								<td><a href="#">notice</a></td>
								<td><span class="glyphicon glyphicon-ok-sign"></span></td>
								<td>새글</td>
								<td>총 게시글</td>
								<td><button class="btn btn-warning btn-xs" onclick="location.href='noticeBoardList';">
										<span class="glyphicon glyphicon-list-alt"></span>
									</button></td>
								<td><button class="btn btn-success btn-xs" onclick="location.href='noticeBoardWrite';">
										<span class="glyphicon glyphicon-pencil"></span>
									</button></td>
							</tr>

							<tr>
								<td>3</td>
								<td>FAQ</td>
								<td><a href="#">faq</a></td>
								<td><span class="glyphicon glyphicon-ok-sign"></span></td>
								<td>새글</td>
								<td>총 게시글</td>
								<td><button class="btn btn-warning btn-xs" onclick="location.href='faqBoardList';">
										<span class="glyphicon glyphicon-list-alt"></span>
									</button></td>
								<td><button class="btn btn-success btn-xs" onclick="location.href='faqBoardWrite';">
										<span class="glyphicon glyphicon-pencil"></span>
									</button></td>
							</tr>

							<tr>
								<td>4</td>
								<td>Q&A</td>
								<td><a href="#">qna</a></td>
								<td><span class="glyphicon glyphicon-ok-sign"></span></td>
								<td>새글</td>
								<td>총 게시글</td>
								<td><button class="btn btn-warning btn-xs" onclick="location.href='qnaBoardList';">
										<span class="glyphicon glyphicon-list-alt"></span>
									</button></td>
								<td><button class="btn btn-success btn-xs" onclick="location.href='qnaBoardWrite';">
										<span class="glyphicon glyphicon-pencil"></span>
									</button></td>
							</tr>

							<tr>
								<td>5</td>
								<td>1:1문의</td>
								<td><a href="#">inquiry</a></td>
								<td><span class="glyphicon glyphicon-remove-sign"></span></td>
								<td>새글</td>
								<td>총 게시글</td>
								<td><button class="btn btn-warning btn-xs" onclick="location.href='inquiryBoardList';">
										<span class="glyphicon glyphicon-list-alt"></span>
									</button></td>
								<td><button class="btn btn-success btn-xs" onclick="location.href='inquiryBoardWrite';">
										<span class="glyphicon glyphicon-pencil"></span>
									</button></td>
							</tr>

						</tbody>
					</table>
					<%@ include file="../include/footer.jsp"%>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
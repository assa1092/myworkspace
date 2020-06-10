<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT 제품 리뷰</title>
</head>
<body>
	<h1>IT 제품 리뷰</h1>
	번호 : ${list.num }
	<br> 작성일 : ${list.writeday }
	<br> 제목 : ${list.title }
	<br> 작성자 : ${list.id }
	<br> 내용 : ${list.content }
	<br> 카테고리 : ${list.category }
	<br> 조회수 : ${list.readcnt }
	<br> 별점 : ${list.starpoint }
	<br>

	<a href="reviewupdateui.do?num=${list.num }">수정</a> |
	<a href="reviewdelete.do?num=${list.num }">삭제</a> |
	<a href="reviewlist.do">목록</a>
</body>
</html>
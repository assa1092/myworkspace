<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리뷰 상세 보기 </h1>
	Num : ${dto.num}<br>
	제목 : ${dto.title }<br>
	작성자 : ${dto.id }<br>
	카테고리: ${dto.category }<br>
	작성일: ${dto.writeday }<br>
	조회수: ${dto.readcnt }<br>
	별 점 : ${dto.starpoint}<br>
	내 용 : ${dto.content }<br>
	
	   <a href="reviewupdateui.do?num=${dto.num}&id=${dto.id}">수 정</a> 
	|  <a href="reviewdelete.do?num=${dto.num}">삭 제</a> 
	|  <a href="#">댓 글</a> 
	|  <a href="reviewlist.do">목 록</a> 
</body>
</html>
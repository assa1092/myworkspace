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
	<h1>글 자세히 보기</h1>
	작성자 : <input name="writer" value="${dto.writer}"><Br>
	작성일자 :<input name="writeday" value="${dto.writeday}"><Br>
	조회수 : <input name="readcnt" value="${dto.readcnt}"><Br>
	제  목 :<input name="title" value="${dto.title}"><Br>
	내  용 :<input name="content" value="${dto.content}"><Br>


	<a href="boardupdateui.do?num=${dto.num}">수정</a> |
	<a href="boarddelete.do?num=${dto.num}">삭제</a> |
	<a href="boardreplyui.do?num=${dto.num}">댓글</a> |
	<a href="boardlist.do">목록</a> |
</body>
</html>
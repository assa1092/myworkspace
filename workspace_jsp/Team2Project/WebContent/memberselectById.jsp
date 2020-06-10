<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 자세히 보기</h2>
	
	ID: ${mDTO.id}<br>
	이름: ${mDTO.name}<br>
	
	<a href="memberupdateui.do?id=${mDTO.id}">수정</a> | 
	<a href="memberdelete.do?id=${mDTO.id}">삭제</a> | 
	<a href="memberselect.do">목록</a> | 


</body>
</html>
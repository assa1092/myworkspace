<%@page import="member.MemberDTO"%>
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
<script>
      alert('다른사람은 건들지 맙시다.');
</script>
	<%
      MemberDTO login = (MemberDTO) session.getAttribute("login");
   %>
	
		<h1>사용자 정보</h1>
		아이디 : ${login.id}<br>
		이  름 : ${login.name}<br>
		<a href="memberlist.do?">목록으로</a>
	
	

</body>
</html>
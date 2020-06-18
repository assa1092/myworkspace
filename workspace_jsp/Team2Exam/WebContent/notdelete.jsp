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
	<%
      MemberDTO login = (MemberDTO) session.getAttribute("login");
   %>
	<form action="memberinsert.do" method="post">
		<h1>사용자 정보</h1>
		아이디 : <input name="id">${login.id }<br>
		이  름 : <input name ="name">${login.name }<br>
	</form>

</body>
</html>
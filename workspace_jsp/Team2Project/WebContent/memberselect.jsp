<%@page import="javax.naming.InitialContext"%>
<%@page import="member.domain.MemberDTO"%>
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






<a href="${empty login ? 'memberloginui.do' : 'memberlogout.do'}"> ${empty login ? '로그인' : '로그아웃' }</a>

	<a href="${empty login ? 'memberinsertui.do' : ' '}">${empty login ? '회원가입' : ' '}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<c:if test="${!empty login}">
	<a href ="memberselectById.do?id=${login.id}">내정보보기</a>
	</c:if>
    <c:if test="${manager}"><a href="membergrantui.do">권한부여</a></c:if>
	
	
	
	
	
	
	<%--<a href="grantui.do">권한부여</a>
	 --%>

	<%--<% if(manager){
		out.print("<a href=");
		out.print('"');
		out.print("grantui.do");
		out.print('"');
		out.print(">권한부여</a>");
	}--%>
	
	
	
	
	
	<%// <c:forEach items="${list}" var="dto">
	//<a href="selectById.do?id=${dto.id}">${dto.id} : ${dto.name}</a><br>
	//</c:forEach> 
		%>
		
</body>
</html>
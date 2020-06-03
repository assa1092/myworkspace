<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("good");
		list.add("morning");
		list.add("굿 모닝..");
		
		request.setAttribute("list", list);	// ("list", list) : list를  "list"이름으로 
		// selectCommand 에 있는것과 동일...
	%>
	<!-- items 배열이나 리스트를 많이 들어감...무조건.EL 형태로 -->
	<!-- 값을 받아야한다... var ="msg" -->
	<!-- 출력할 값도 EL로... -->
	<c:forEach items="${list }" var="msg">
		${msg}<br>
	</c:forEach>
	

</body>
</html>
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

	<h1>Expression Language(표현 언어)</h1>
	
	삼항 연산 가능<br>
	<!-- 삼항 연산 가능 -->
	${3 > 4 ? 100 : -5 }<br>
	<%
		request.setAttribute("a", 11);
	%>
	<!-- 바인딩이 안된값은 EL에서는 쓸수없다... -->
	<!-- " " 겹치면 하나는 ' ' 로 바꾸어야 한다... -->
	<a href='${ a > 3 ? "http://www.naver.com" : "http://www.google.com" }'>hello</a>
	
	<hr>
	산술 연산 가능<br>
	<!-- 산술 연산 가능 -->
	${111 }<br>
	${"hello" }<br>
	${1+2 }<br>
	${1-2 }<br>
	${1*2 }<br>
	${1/2 }<br>
	${1%2 }<br>
	<hr>
	
	 비교 연산 가능<br>
	<!-- 비교 연산 가능 -->
	${1>2 }<br>
	${1>=2 }<br>
	${1<2 }<br>
	${1<=2 }<br>
	${1==2 }<br>
	${1!=2 }<br>
	<hr>
	
	논리 연산 가능<br>
	<!-- 논리 연산 가능 -->
	${true && true }<br>
	${(3>4) && (5<6)}<br>
	${true || false }<br>
	
	



</body>
</html>
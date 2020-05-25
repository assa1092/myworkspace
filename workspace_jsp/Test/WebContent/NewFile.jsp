<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재시각 : 2020년 5월25일 오후 2시 10분
<!-- 정적인 웹 프로그래밍--> 
<hr>
<%
	Date d = new Date();
	out.print(d.toLocaleString());
	// 동적인 웹 프로그래밍
%>
</body>
</html>
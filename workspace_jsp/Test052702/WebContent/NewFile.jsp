<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// request가 아닌 application으로 보냈기 때문에 application 으로 접근한다...
	
	String hello  = (String) application.getAttribute("hello");
	List<StringBuffer> list =(List<StringBuffer>) application.getAttribute("list");
	
	// int로 받으면 에러발생...반드시 박싱...Integer로...
	Integer count = (Integer) application.getAttribute("count");
	
	out.print(count+"<br>");
	out.print(hello);
	
	out.print(list);
	
	

%>

</body>
</html>
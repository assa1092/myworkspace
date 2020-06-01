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
		// 생성자나 메소드 안쪽과 동일한 개념...
		request.getAttribute("");
		int a =10;
		a = 5;
				
		out.print("hhhh");
	%>
	
	<%
		// 이런 식으로 많이 쓴다..
		a=10;
		for(int i=0;i<a;i++){
	%>
		hello : <%= i %>
		<br>
	
	
	<% 
		}
	%>
	
	
	

</body>
</html>
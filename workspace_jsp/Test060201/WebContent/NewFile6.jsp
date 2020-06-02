<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="login" class="com.naver.LoginBean"/>

<!-- login 객체가 아이디 값을 m003으로 채워 넣는다.  -->
<jsp:setProperty property="id" name="login" value="m003"/>
<!-- login 객체가 pw 값을 1으로 채워 넣는다.  -->
<jsp:setProperty property="pw" name="login" value="1"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= login.getId() %> : <%= login.getPw() %>
	<hr>
	<%-- EL 이 자바빈 도 지원해 준다... --%>
	${login.id } : ${login.pw }
	<hr>
	
	<!-- login 객체의 id, pw의 값을 가져온다...  -->
	<jsp:getProperty property="id" name="login"/>
	<jsp:getProperty property="pw" name="login"/>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
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
<div style="padding: 20px 70px 20px 70px;">
<h1>로그인</h1>

<form action="memberlogin.do" method="post">
로그인 ID <br>
<input type="text" name="id" style="border:solid;" required> <br>
PassWord <br>
<input type="password" name="pw" style="border:solid;" required> <br><br>
<input type="submit" value="로그인">
</form>
<br>
<form action="memberinsertui.do" method="post">
<input type="submit" value="회원가입">
</form><br><br><br>
<jsp:include page="footer.jsp" />
</div>
</body>
</html>
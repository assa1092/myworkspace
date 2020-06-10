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

<h1>로그인</h1>

<form action="memberlogin.do" method="post">
로그인 ID <br>
<input type="text" name="id" style="border:solid;"> <br>
PassWord <br>
<input type="text" name="pw" style="border:solid;" > <br>

<input type="submit" value="로그인">


</form>

</body>
</html>
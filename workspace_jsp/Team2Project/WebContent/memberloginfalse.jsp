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
<div style="padding: 20px 70px 20px 70px;">
<h1>아이디나 비밀번호가 틀렸습니다.</h1><br>


<button type="button" class="btn btn-outline-primary" onclick="location.href='memberloginui.do'">로그인화면으로</button>
<button type="button" class="btn btn-outline-success" onclick="location.href='reviewlist.do'">목록으로</button>
<br>
<br><br><br><br>
<jsp:include page="footer.jsp" />
</div>
</body>
</html>
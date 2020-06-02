<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="login" class="com.naver.LoginBean"/>

<!-- LoingBean의 변수명과...input의 이름이 같다면  -->
<!-- login 하나하나를 지정하지 않고  * 로 다 가져올수있다... -->
<jsp:setProperty property="*" name="login"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${login.id } : ${login.pw }

</body>
</html>
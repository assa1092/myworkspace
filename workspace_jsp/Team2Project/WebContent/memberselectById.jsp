<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="padding: 20px 70px 20px 70px;">
<jsp:include page="header.jsp" />
	<h2>회원 정보 자세히 보기</h2>

	ID: ${mDTO.id}
	<br> 이름: ${mDTO.name}
	<br>
	<c:if test="${customer }">권한: customer<br></c:if>
	<c:if test="${admin }">권한: admin<br></c:if>
	<c:if test="${manager}">권한: manager<br></c:if>
		

<button type="button" class="btn btn-outline-success" onclick="location.href='memberupdateui.do?id=${mDTO.id}'">수정</button>
<button type="button" class="btn btn-outline-success" onclick="location.href='memberdelete.do?id=${mDTO.id}'">탈퇴</button>
<button type="button" class="btn btn-outline-success" onclick="location.href='reviewlist.do'">목록</button>
	
<br><br><br>
<jsp:include page="footer.jsp" />
</div>
</body>
</html>
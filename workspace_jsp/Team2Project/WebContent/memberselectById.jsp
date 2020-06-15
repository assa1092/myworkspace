<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div style="padding: 20px 70px 20px 70px;">
		<jsp:include page="header.jsp" />
		<h2>회원 정보 자세히 보기</h2>

		ID: ${mDTO.id} <br> 이름: ${mDTO.name} <br>
		<c:if test="${customer }">권한: customer<br>
		</c:if>
		<c:if test="${admin }">권한: admin<br>
		</c:if>
		<c:if test="${manager}">권한: manager<br>
		</c:if>

		<button class="btn btn-outline-success" onclick="location.href='memberupdateui.do?id=${mDTO.id}'">수정</button>
		<button class="btn btn-outline-success" onclick="memberDelete('${mDTO.id}')">탈퇴</button>
		<button class="btn btn-outline-success" onclick="location.href='reviewlist.do'">목록</button>


		<script type="text/javascript">
			function memberDelete(id) {
				var isOk = confirm("모든 게시글이 삭제됩니다. 탈퇴하시겠습니까?");
				if (isOk == true) {
					location.href = "memberdelete.do?id=" + id;
				}
			}
		</script>



		<br>
		<br>
		<br>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
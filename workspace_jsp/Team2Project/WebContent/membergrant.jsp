<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>권한 관리</h1>
	<p style="text-align: center">
		<a href="memberselect.do">메인화면</a>
	</p>
	<h3>매니저</h3>
	<table>

		<thead>
			<tr>
				<th>id</th>
				<th>이름</th>
				<th>권한</th>
				<th>탈퇴</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${man }" var="list">
				<tr>
					<td>${list.id }</td>
					<td>${list.name }</td>
					<td>
						<button onclick="grant('${list.id}', 'manager')">권한 제거</button>
					</td>
					<td>
						<button onclick="deleteMember('${list.id}')">회원 탈퇴</button>
					</td>
			</c:forEach>
		</tbody>




	</table>

	<h3>회원</h3>
	<table>


		<thead>
			<tr>
				<th>id</th>
				<th>이름</th>
				<th>권한</th>
				<th>탈퇴</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cus }" var="list">
				<tr>
					<td>${list.id }</td>
					<td>${list.name }</td>
					<td>
						<button onclick="grant('${list.id}', 'customer')">권한 부여</button>
					</td>
					<td>
						<button onclick="deleteMember('${list.id}')">회원 탈퇴</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>




	</table>


	<script>
		
	</script>

</body>
<script>
	function grant(id, property) {
		if (property == 'manager') {
			var isOk = confirm("권한을 제거하시겠습니까?");

		} else {
			var isOk = confirm("권한을 부여하시겠습니까?");

		}
		if (isOk == true) {
			document.location.href = "grant.do?id=" + id + "&&property="
					+ property;
		}
		return;
	}

	function deleteMember(id) {
		var isOk = confirm("탈퇴시키시겠습니까?");
		if (isOk == true) {
			document.location.href = "delete.do?id=" + id;
		}
		return;
	}
</script>

</html>

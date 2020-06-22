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
<script>
	function grant(id, property){
			
		if(property == 'manager'){
			var isOk = confirm("권한을 제거 하시겠습니까?");
		} else {
			var isOk = confirm("권한을 부여하시겠습니까?");
		}
		
		if(isOk == true){
			document.location.href ="membergrant.do?id=" + id +"&&property=" + property; 
		}
		return ;
	}
	
	function deleteMember(id){
		var isOk = confirm("해당 id의 모든 게시글이 삭제됩니다. 탈퇴하시겠습니까?");
		if (isOk == true) {
			document.location.href="membergrantdelete.do?id=" + id;
		}
		return ;
	}
</script>
<body>
	<h1>회원 관리</h1>

	<c:if test="${admin}">
		<h3>매니저</h3>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이 름</th>
					<th>권 한</th>
					<th>탈 퇴</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${managerList}" var="list">
					<tr>
						<td>${list.id}</td>
						<td>${list.name}</td>
						<td>
							<button class="btn btn-outline-warning" onclick="grant('${list.id}','manager')">권한 제거</button>
						</td>
						<td>
							<button class="btn btn-outline-danger" onclick="deleteMember('${list.id}')">회원 탈퇴</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<h3>회 원</h3>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이 름</th>
				<c:if test="${admin}">
					<th>권 한</th>		
				</c:if>
				<th>탈 퇴</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customerList}" var="list">
				<tr>
					<td>${list.id}</td>
					<td>${list.name}</td>
					<c:if test="${admin}">
						<td>
							<button class="btn btn-outline-success"
                              onclick="grant('${list.id}', 'customer')">권한 부여</button>
						</td>					
					</c:if>
						
					<td>
						<button class="btn btn-outline-danger" 
							onclick="deleteMember('${list.id}')">회원 탈퇴</button>
					</td>
				</tr>				
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
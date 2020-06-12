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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div style="padding: 20px 70px 20px 70px;">
	<h2>회원 가입</h2>
	<form action="memberinsert.do" method="post">
		ID: <input name="id" id="id" required> <button id="check">중복체크</button><br><br>
		이름: <input name="name" required><br><br>
		PW: <input name="pw" type="password" required><br><br>
		<input type="submit" value="가입"><br>
	
	</form>
	
	<script type="text/javascript">
	
		$(document).ready(function(){
			$("#check").click(function(event){
				event.preventDefault();
				var id = $("#id").val();

				
				$.ajax({
					type: "get",
					url: "idchecker",
					data: {
						id: id
					},
					
					dataType: "text",
					success: function(result) {
						alert(result);
					}
				}); 
				
			});
		});
	</script>
<br><br><br>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
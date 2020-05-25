<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- form 태그를 통해 서버에 전달하거나 요청을 하게되는데 --%>
<%-- action 에 요청할 서블릿 주소를 입력해준다.--%>
<%-- method 에는 get/post 방식중 하나를 정한다. 디폴트는 get 방식--%>
<%-- click버튼인 submit을 만듬. 이 버튼을 클릭하게되면 서블릿을 요청 --%>
	
	<form action="test" method= "post">
	이름 : <input type="text" name="name"> <br>
		<input type = "submit" value = "click">
	</form>

</body>
</html>
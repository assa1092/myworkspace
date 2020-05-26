<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입 화면</h1>

<!-- input 태그의 형식
1. type  : 입력 태그의 유형을 설정하는 속성
2. value : 입력 태그의 초기값을 설정하는 속성
3. name  : 서버로 전달되는 이름을 설정하는 속성 
 -->
 
<!-- form 테그에서 서버로 넘어가기위해서는 input 테그에 name 을 꼭 써서한다. -->

<!-- url pattern 값이 insert -->
<form action="insert" method = "post"> 
아이디 : <input name = "id" ><br>
이름   : <input name = "name"><br>
나이   : <input name = "age"><br>
<input type = "submit" value ="회원 가입">
</form>
</body>
</html>
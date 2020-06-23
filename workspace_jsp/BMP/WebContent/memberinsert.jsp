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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="memberinsert.do" method="post">
		
		ID : <input name="id"  id="id"><button id="check" >ID 중복 체크</button><br>
		
		Name : <input name="name" ><br>
		Pw : <input name="pw" type="password"><br>
		<input type="submit" value = "회원가입">
	</form>
	
<script type="text/javascript"> 
//jquery 식...
$(document).ready(function(){	// $(document).ready()안에 function(){}
	// selector... 태그명 button.. 버튼의 event가 발생하면
	$("#check").click(function(event) {	// $("button").click() 안에 function(event){}
		// event의 버튼 누르면 넘어가는 기능을 막아놓은것...
		event.preventDefault();
		// input 된 "id"값 가져오기.
		var id = $("#id").val();
		
		// ajax...function Code $.ajax({})
		$.ajax({
			type :"get"	,	// get 방식으로 보낸다...
			url : "Idchecker", 	// 어디로...idcheck 서블릿으로.
			data : {			// data : { 보낼 data }
				id : id			// var id = $("#id").val(); 요기의 id
				
			}, 			// data 속성 다음에 , 넘어오는 data Type
			dataType : "text",
			success : function(result) {	// 성공했을때의 작업...여러작업할때는 function으로 묶어준다.
				alert(result);			// 성공했을때의 결과값을 보여주기.
			}			
		});
	});
});

</script>

</body>
</html>
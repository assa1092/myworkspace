<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<button>at1. test</button>
	<p></p>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function(){
				$.ajax({		// ajax() 와 송신을 하겠다는 의미...여러가지 일을 하기때문에 .ajax({})
					type : 'post',			// type 데이터 송신방법 post로......
					url : '/at1',
					dataType : 'text', 		// 자료형...
					data : {				// data 는 값이 여러개 이므로 배열로...{}... 속성은'' 
						'msg' : "hello"
					},
					success : function(result){		// 성공했을시에....하는일... 보통 함수로...정의
						console.log(result);			// 잘 되었는지 콘솔에 결과 찍어보는것...

						$("p").text(result);		// p 태그에 result 값을 넣어주라....
						// var msg = $("p").text(); // 이렇게 넣어도 된다...
						
					},
					error : function(request, status, error){		// 실패했을시...
						//console.log(status);		//
						
						// 어떤 상황에서 에러가 났는지 보여주게.... 
						console.log("code" + request.status +"\n"+ "msg:" +request.responseText+"\n" +"error : " + error);
					},
					complete : funtcion(){
							alert('ok');	// 성공이든 실패든 무조건 실행....
					}			
	
					});	
			});
		});
	</script>

</body>
</html>
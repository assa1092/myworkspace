<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
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
	<button>at4 test</button>
	<p></p>
	

	<script type="text/javascript">
	<!-- 리스트로 데이터를 받았을때... -->
	<%
	List<MemberDTO> list = new ArrayList<MemberDTO>();
	list.add(new MemberDTO("m001", "kim", 22));
	list.add(new MemberDTO("m002", "lee", 88));
	list.add(new MemberDTO("m003", "park", 66));
	
	// 문자열로 바꿔서 JSON 으로
	
	ObjectMapper mapper = new ObjectMapper();
	String listStr = mapper.writeValueAsString(list);	// list 데이터를 문자열로
	
	// 자바스크립트에서는 인식을 못하므로... pageContext에 바인딩시킨다.
	pageContext.setAttribute("listStr", listStr);	// 이러면 JSON으로 만들어졌다.
	%>


//dataType : 보내는 타입이 아니라 통신 끝나고 넘겨받는 데이터 타입
		$(document).ready(function(){
			$("button").click(function(){
				$.ajax({
					type : 'post',
					url : '/at4',
					dataType : 'text', 
					data : {
						listStr : JSON.stringify(${listStr})	// 문자열로 만든것을 JSON으로 바꾼다..
					},
					success : function(result){
						console.log(result);

						var obj = JSON.parse(result);

						$("p").text(obj[0]['id']);
						// alert(obj[0]['name']);
						for(var i=0; i<obj.length;i++){
							for(x in obj[i]){
								console.log(x);
								console.log(obj[i][x]);		// obj
								console.log("================");
							}

						}	

						
					}
				});
			});
		});
	</script>
</body>
</html>
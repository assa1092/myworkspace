<%@page import="kr.co.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="insertui">회원 등록</a>

	<h1>모든 회원 정보 목록</h1>
	
	<!-- DB에서 받은 데이터를 뿌려주는 방법 -->
	<!-- request, response, out 은 
			내장객체라 선언없이 그냥 쓸수있다. -->
	<%
	
		Object oList = request.getAttribute("list");
		List<MemberDTO> list = null;
		if(oList != null){			// list 에 값이 있으면 출력..
			list = (List<MemberDTO>)oList;		// 강제 형변환
			for(int i = 0;i<list.size();i++){
				 MemberDTO dto= list.get(i);
				 
				 out.print(dto);
				 out.print("<br>");
			}
		}
	
	%>

</body>
</html>
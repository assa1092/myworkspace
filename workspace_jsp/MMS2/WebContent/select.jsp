<%@page import="kr.co.domain.MemberDTO"%>
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
	<!-- 로그인 화면이면 .do -->
	<!-- 삼항 연산자  int c = a>b? 100 : -1-->
	<!-- 로그인이 되어있으면 로그아웃으로 안되어있으면 로그인으로 나오게... -->
	<!-- 로그인이 되어있으면 로그인 화면으로 안되었으면 로그아웃 화면으로 -->
	<a href="${empty login? 'loginui.do' : 'logout.do'}">${empty login? '로그인' : '로그아웃'}</a> 
	<br>
	
	<a href="insertui.do">회원 등록</a><br><br>
	
	
	<%
		List<MemberDTO> list =  (List<MemberDTO> )request.getAttribute("list");
		for(int i =0; i<list.size(); i++) {
			
			MemberDTO dto = list.get(i);
			out.print("<a href='selectById.do?id=" + dto.getId() + "'>");
			out.print(dto.getId());
			out.print(" : ");
			out.print(dto.getName());
			out.print("</a>");
			out.print("<br>");
			
		}
	%>
	

</body>
</html>
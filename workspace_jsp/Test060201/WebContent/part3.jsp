<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<footer>
	푸터 입니다.
	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name"); 
	%><br>
	<%=id %> : ${param.id}<br>
	<%=name %> : ${param.name}<br>
	${param.hello}
	
	
</footer>
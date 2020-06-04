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
<body>
	<!-- 디렉토리 방식으로 servlet  --> 
	<!-- 파일을 업로드 할때 태그에서 ENCTYPE="multipart/form-data"라는 애트리뷰트를 반드시 써야 한다 -->
	
	<form enctype ="multipart/form-data" action="upload" method="post">
		title : <input name = "title"><br>
		첨부파일 : <input type="file" name="file"><br>
		<input type="submit" value ="저장">
	
	</form>

</body>
</html>
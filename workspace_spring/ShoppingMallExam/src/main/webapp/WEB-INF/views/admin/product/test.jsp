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

<form action="/admin/product/list" method="get">
<input required type="text" name ="aa" class="a"><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<input required type="text" name ="aa" class="b"><br><br><br><br><br><br><br><br><br><br><br><br>
<input required type="text" name ="aa" class="c"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<input required type="text" name ="aa" class="d"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<input required type="text" name ="aa" class="e"><br><br><br><br><br><br><br><br><br><br>


</form>
<button class="btn btn-danger submit" type="submit">제출</button>
<script type="text/javascript">
$(document).ready(function(){
	$(".submit").click(function(e){
		e.preventDefault();
		if($(".a").val()==""){
			alert("빈칸써라");
			$(".a").focus();
			return false;
		}
		else
			$("form").submit();
	
	});
	
});

</script>
</body>
</html>
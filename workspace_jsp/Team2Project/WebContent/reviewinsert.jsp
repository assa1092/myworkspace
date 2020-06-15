<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>IT 제품 리뷰</title>
</head>
<body>
<div style="padding: 20px 70px 20px 70px;">
<jsp:include page="header.jsp" />
	<h1>글쓰기</h1>
	<%-- <form action="reviewinsert.do" method="post">

		작성자 : <input name="id" readonly value="${login.id}"><br>
		제목 : <input name="title"><br>
		별점 : <select name="starpoint">
				
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select><br> 
		카테고리 :		
			<select name="category">
				
				<option value="컴퓨터">컴퓨터</option>
				<option value="디지털">디지털</option>
				<option value="가전">가전</option>
			</select>
		
		<br> 내용 : <br>
		<textarea rows="5" name="content"></textarea>
		<br> <input type="submit" value="등록">
	</form> --%>
	<form action="reviewupload.do" method="post" enctype="multipart/form-data">
	
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="id">작성자</label>
      <input name = "id" type="text" class="form-control" id="id" value="${login.id}">
    </div>
 
    <div class="form-group col-md-6">
      <label for="category">카테고리</label>
      <select name="category" class="form-control" id="category">
      			<option value="컴퓨터">컴퓨터</option>
				<option value="디지털">디지털</option>
				<option value="가전">가전</option>
	  </select><br> 
    </div>
  </div>
  <div class="form-group">
    <label for="title">제목</label>
    <input name="title" type="text" class="form-control" id="title" placeholder="제목을 입력하세요.">
  </div>
  <div class="form-group">
    <label for="content">내용</label>
    <textarea rows="10" name="content"  class="form-control" id="content" placeholder="내용을 입력하세요."></textarea>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="starpoint">별점</label>
      <select name="starpoint" class="form-control" id="starpoint">
      			<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select><br> 
    </div>
    
  </div>
  <div class="form-group">
   
  </div>
  <div class="form-group">
    <label for="file">첨부파일</label>
    <input type = "file" name="file"  class="form-control" id="file">
  </div>
 
  <button type="submit" class="btn btn-primary">글쓰기</button>
</form>
	<br><br><br>
	
	<jsp:include page="footer.jsp" />
	</div>
	
</body>
</html>
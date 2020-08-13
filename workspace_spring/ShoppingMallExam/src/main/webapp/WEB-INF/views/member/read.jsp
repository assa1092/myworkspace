<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
   <div class="container">
      <div class="row text-center">
         <h1>회원 정보</h1>
      </div>
      
      <div class="row">                
           <table border="1" width="400px">
           
            <tr>
             <div class="form-group">
            <td><label for="memberId">아이디</label><td> 
            <td><input readonly value="${to.memberId}" class="form-control"></td>         
         </div>
         </tr> 

         <tr>
             <div class="form-group">
            <td><label for="memberName">이름</label><td> 
            <td><input readonly value="${to.memberName}" class="form-control"></td>         
         </div>
         </tr> 
         
         <tr>
             <div class="form-group">
            <td><label for="memberBirth">생년월일</label><td> 
            <td><input readonly value="${to.memberBirth}" class="form-control"></td>         
         </div>
         </tr> 
         
         
           <tr>
             <div class="form-group">
            <td><label for="memberEmail">이메일</label><td> 
            <td><input readonly value="${to.memberEmail}" class="form-control"></td>         
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberTel">일반전화</label><td> 
            <td><input readonly value="${to.memberTel}" class="form-control"></td>         
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberPhone">휴대전화</label><td> 
            <td><input readonly value="${to.memberPhone}" class="form-control"></td>         
         </div>
         </tr> 
         
         <tr>
             <div class="form-group">
            <td><label for="memberGender">성별</label><td> 
            <td><input readonly value="${to.memberGender}" class="form-control"></td>         
         </div>
         </tr> 
         
         
          <tr>
             <div class="form-group">
            <td><label for="memberZipcode">우편번호</label><td> 
            <td><input readonly value="${to.memberZipcode}" class="form-control"></td>          
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberAddress_1">주소</label><td> 
            <td><input readonly value="${to.memberAddress_1}" class="form-control"></td>          
         </div>
         </tr> 
         
             <tr>
             <div class="form-group">
            <td><label for="memberAddress_2">상세주소</label><td> 
            <td><input readonly value="${to.memberAddress_2}" class="form-control"></td>          
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberPetName">반려동물 이름</label><td> 
            <td><input readonly value="${to.memberPetName}" class="form-control"></td>         
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberPetAge">반려동물 나이</label><td> 
            <td><input readonly value="${to.memberPetAge}" class="form-control"></td>         
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberHolder">예금주</label><td> 
            <td><input readonly value="${to.memberHolder}" class="form-control"></td>         
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberBank">은행명</label><td> 
            <td><input readonly value="${to.memberBank}" class="form-control"></td>         
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberAccount">계좌번호</label><td> 
            <td><input readonly value="${to.memberAccount}" class="form-control"></td>         
         </div>
         </tr> 
         
           <tr>
             <div class="form-group">
            <td><label for="memberRegDate">가입일</label><td> 
            <td><input readonly value="${to.memberRegDate}" class="form-control"></td>         
         </div>
         </tr> 
         
         
         
 </table>
 </div>
 
 
 
 
 
 
 
 
      <div class="row">
         <div class="form-group">
            <button class="btn btn-warning" id="update">수정</button>
            <button class="btn btn-danger" id="delete">삭제</button>
            <button class="btn btn-primary" id="list">목록</button>
         </div>
      </div>

          
         </div>
 <script type="text/javascript">
		var memberno = ${to.memberNo}

		$("#update").click(function() {
			location.assign("/member/update/${to.memberNo}");
		});

		$("#delete").click(function() {
			location.assign("/member/delete/${to.memberNo}");
		});

		$("#list").click(function() {
			location.assign("/member/list");
		});
	
</script>
</body>


</html>
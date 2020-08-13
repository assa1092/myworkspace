<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>

<section id="container">
<div id="container_box">
<section id="content">
 <form role="form" method="post" autocomplete="off">
  
  <!-- <div class="input_area">
   <label for="memberNo" ></label>
   <input type="hidden" id="memberNo" name="memberNo" required="required" />      
  </div> -->
  
  <div class="input_area">
   <label for="memberId">아이디</label>
   <input type="text" id="memberId" name="memberId" required="required" />      
  </div>
  
  <div class="input_area">
   <label for="memberPw">비밀번호</label>
   <input type="password" id="memberPw" name="memberPw" required="required" />      
  </div>
  
  <div class="input_area">
   <label for="memberPw">비밀번호 확인</label>
   <input type="password" id="memberPw" name="memberPw" required="required" />      
  </div>
  
  <div class="input_area">
   <label for="memberName">이름</label>
   <input type="text" id="memberName" name="memberName" required="required" />      
  </div>
  
    <div class="input_area">
   <label for="memberZipcode">우편번호</label>
   <input type="text" id="memberZipcode" name="memberZipcode" required="required" />      
  </div>
    <div class="input_area">
   <label for="memberAddress_1">기본주소</label>
   <input type="text" id="memberAddress_1" name="memberAddress_1" required="required" />      
  </div>
    <div class="input_area">
   <label for="memberAddress_2">나머지주소</label>
   <input type="text" id="memberAddress_2" name="memberAddress_2" required="required" />      
  </div>
    <div class="input_area">
   <label for="memberTel">일반전화</label>
   <input type="tel" id="memberTel" name="memberTel"/>      
  </div>
    <div class="input_area">
   <label for="memberPhone">휴대전화</label>
   <input type="tel" id="memberPhone" name="memberPhone" required="required" />      
  </div>
    <div class="input_area">
   <label for="memberEmail">이메일</label>
   <input type="text" id="memberEmail" name="memberEmail" required="required" />      
  </div>
    <div class="input_area">
   <label for="memberPetName">반려동물 이름</label>
   <input type="text" id="memberPetName" name="memberPetName"/>      
  </div>
   
    <div class="input_area">
   <label for="memberPetAge">반려동물 나이</label>
   <input type="number" id="memberPetAge" name="memberPetAge"/>      
  </div>
  
    <div class="input_area">
   <label for="memberHolder">예금주</label>
   <input type="text" id="memberHolder" name="memberHolder" required="required" />      
  </div>
  
    <div class="input_area">
   <label for="memberBank">은행명</label>
   <input type="text" id="memberBank" name="memberBank" required="required" />      
  </div>
  
    <div class="input_area">
   <label for="memberAccount">계좌번호</label>
   <input type="number" id="memberAccount" name="memberAccount" required="required" />      
  </div>
  
  <button type="submit" id="insert_btn" name="insert_btn">회원가입</button>
  
 </form>   
</section>
</div>
</section>
</body>
</html>

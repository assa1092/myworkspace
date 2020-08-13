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
<%@ include file="../include/header.jsp" %>
<script>
 $(document).ready(function(){
      $("#btnLogin").click(function(){
          var memberId = $("#memberId").val();
          var memberPw = $("#memberPw").val();
          if(memberId == "") {
              alter("아이디를 입력하세요.");
              $("#memberId").focus();
              return;
              }
          if(memberPw == ""){
              alter("아이디를 입력하세요.");
              $("#memberPw").focus();
              return;
              }
          document.form1.action="${path}/member/loginCheck.do"
          document.form1.submit();
          });
	 });
</script>
</head>

<body>

<h2>로그인</h2>
   <form name="form1" method="post">
      <table border="1" width="400px">
         <tr>
           <td>아이디</td>
           <td><input name="memberId" id="memberId"></td>
           </tr>
          <tr>
           <td>비밀번호</td>
           <td><input type="password" name="memberPw" id="memberPw"></td>
           </tr>
         <tr>
         <td colspan="2" align="center">
         <button type="button" id="btnLogin">로그인 </button>
         
         <c:if test="${msg == 'failure'}">
         <div style="color: red">
               아이디 또는 비밀번호가 일치하지 않습니다.
               
               </div> 
          </c:if>
               
         <c:if test="${msg == 'logout'}">
         <div style="color: red">
                          로그아웃되었습니다.
               </div>
           </c:if> 
               </td>
               </tr>
               </table>
               </form>

</body>
</html>
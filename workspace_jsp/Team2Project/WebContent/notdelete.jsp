<%@page import="member.domain.MemberDTO"%>
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

<style>
.bd-placeholder-img {
   font-size: 1.125rem;
   text-anchor: middle;
   -webkit-user-select: none;
   -moz-user-select: none;
   -ms-user-select: none;
   user-select: none;
}

@media ( min-width : 768px) {
   .bd-placeholder-img-lg {
      font-size: 3.5rem;
   }
}

body {
   height: 100%;
}

body {
   display: -ms-flexbox;
   display: flex;
   -ms-flex-align: center;
   align-items: center;
   padding-top: 40px;
   padding-bottom: 40px;
   background-color: #f5f5f5;
}

.form-signin {
   width: 100%;
   max-width: 330px;
   padding: 15px;
   margin: auto;
}

.form-signin .checkbox {
   font-weight: 400;
}

.form-signin .form-control {
   position: relative;
   box-sizing: border-box;
   height: auto;
   padding: 10px;
   font-size: 16px;
}

.form-signin .form-control:focus {
   z-index: 2;
}

.form-signin input[type="email"] {
   margin-bottom: -1px;
   border-bottom-right-radius: 0;
   border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
   margin-bottom: 10px;
   border-top-left-radius: 0;
   border-top-right-radius: 0;
}
</style>
<title>IT 제품 리뷰</title>
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
   <script>
      alert('권한이 없습니다. 감히? 당신이?');
   </script>

   <%
      MemberDTO login = (MemberDTO) session.getAttribute("login");
   %>
   <form class="form-signin" action="memberinsert.do" method="post">
      <div class="text-center">
         <h1 class="h3 mb-3 font-weight-normal">사용자 정보</h1>
         
         
            <input type="text" id="id" class="form-control" name="id"
            placeholder="아이디 : ${login.id}" readonly>
            <label for="inputEmail" class="sr-only"></label>
         

         <label for="inputEmail" class="sr-only"></label>
         <input type="text" id="name" class="form-control" name="name"
         placeholder="이름 : ${login.name}" readonly>
         
         <div class="checkbox mb-3"></div>
         
         <button class="btn btn-lg btn-primary btn-block" type="button"
            onclick="location.href='memberlogout.do'">로그아웃</button>
         <button class="btn btn-lg btn-info btn-block" type="button"
            onclick="location.href='reviewlist.do'">메인화면</button>
      </div>
   </form>
   <%-- <form class="form-signin">


         <table class="table">
            <thead class="thead  table-dark">
               <tr>
                  <th colspan="2">현재 사용자 정보</th>

               </tr>
            </thead>
            <tbody>
               <tr>
                  <th scope="row">아이디</th>
                  <td>${login.id}</td>
               </tr>
               <tr>
                  <th scope="row">이름</th>
                  <td>${login.name}</td>
               </tr>
               <tr>
                  <th scope="row">권한</th>
                  <c:if test="${customer }">
                     <td>customer</td>
                  </c:if>
                  <c:if test="${admin }">
                     <td>admin</td>
                  </c:if>
                  <c:if test="${manager}">
                     <td>manager</td>
                  </c:if>
               </tr>
            </tbody>
         </table>

         <script>
            alert('권한이 없습니다. 감히? 당신이?');
         </script>

      </form>
      <br>
      <form class="form-signin" action="reviewlist.do" method="post">
         <button  class="btn btn-warning">목록으로
            돌아가기</button>
      </form>
      <br>
      <form class="form-signin" action="memberlogout.do" method="post">
         <button class="btn btn-dark">로그아웃</button>
      </form> --%>
   <!-- </div> -->
</body>
</html>
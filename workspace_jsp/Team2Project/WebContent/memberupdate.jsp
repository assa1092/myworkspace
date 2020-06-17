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




</style>
</head>
<%--
<body>
<div style="padding: 20px 70px 20px 70px;">
   <h2>회원 정보 수정</h2>
   <form action="memberupdate.do" method="post">
      ID: <input name="id" value="${dto.id}" readonly><br>
      이름: <input name="name" value="${dto.name}"><br>
      PW: <input name="pw" type="password" required><br>
      <input type="submit" value="수정">
   
   </form><br><br><br>
<jsp:include page="footer.jsp" />
</div>
</body>
 --%>
<body>
   <form class="form-signin" action="memberupdate.do" method="post">
      <div class="text-center">
         <h1 class="h3 mb-3 font-weight-normal">회원 정보 수정</h1>

         <div class="input-group mb-3">
            <div class="input-group-prepend">
               <span class="input-group-text" style="width: 55px;">ID</span>
            </div>
            <input type="text" class="form-control" name="id" value="${dto.id}" readonly
               aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-default">
         </div>
         <div class="input-group mb-3">
            <div class="input-group-prepend">
               <span class="input-group-text" style="width: 55px;">이름</span>
            </div>
            <input type="text" class="form-control" name="name" value="${dto.name}"
               aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-default">
         </div>

         <div class="input-group mb-3">
            <div class="input-group-prepend">
               <span class="input-group-text" style="width: 55px;">PW</span>
            </div>
            <input type="password" class="form-control" name="pw" required
               aria-label="Sizing example input"
               aria-describedby="inputGroup-sizing-default">
         </div>

         <button class="btn btn-lg btn-primary btn-block" type="submit">수정</button>
         <button class="btn btn-lg btn-info btn-block" type="button"
            onclick="location.href='reviewlist.do'">메인화면</button>
         <br>
      </div>
   </form>

   <br>
   <br>
   <br>
   <br>
</body>

</html>
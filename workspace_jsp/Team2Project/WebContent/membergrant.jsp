<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="UTF-8">

<title>IT 제품 리뷰</title>
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
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
   flex-direction: column;
   -ms-flex-align: center;
   align-items: center;
   padding: 40px;
   padding-bottom: 0px;
   background-color: #f5f5f5;
}

.container-fluid {
   max-width: none;
}

.float-right, .container-fluid footer {
   max-width: none;
   width: 100%;
}

.back {
   float: right;
   margin-bottom: 50px;
}

.manager, .customer {
   width: 50%;
   margin: 0px;
   max-width: inherit;
}

.manager {
   float: left;
   padding-right: 20px;
}

.customer {
   float: right;
   padding-left: 20px;
}

th {
   border: 3px solid black;
   border-top: 3px solid black;
   padding: 8px;
   text-align: left;
   max-width: inherit;
}

th.id, th.name {
   width: 35%;
}

th.prpt, th.del {
   width: 15%;
}

td {
   border-bottom: 3px solid silver;
   border-left: 1px solid silver;
   border-right: 1px solid silver;
   text-align: center;
}
</style>
      <c:if test="${!admin }">
         <style>
.customer {
   width: 100%;
}
</style>
      </c:if>
</head>
<body>

   <div class="container-fluid">
      <h1 align="center">회원 관리</h1>
      <br> <br>
      <div class="manager">
         <c:if test="${admin}">
            <h3>매니저</h3>
            <table class="table">
               <thead>
                  <tr class="table-info">
                     <th class="id">아이디</th>
                     <th class="name">이름</th>
                     <th class="prpt">권한</th>
                     <th class="del">탈퇴</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach items="${man }" var="list">
                     <tr class="thead-light">
                        <td style="vertical-align: middle">${list.id }</td>
                        <td style="vertical-align: middle">${list.name }</td>
                        <td>
                           <button class="btn btn-outline-warning"
                              onclick="grant('${list.id}', 'manager')">권한 제거</button>
                        </td>
                        <td style="text-align: center">
                           <button class="btn btn-outline-danger"
                              onclick="deleteMember('${list.id}')">회원 탈퇴</button>
                        </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </c:if>
      </div>

      <div class="customer">
         <h3>회원</h3>
         <table class="table">
            <thead class="thead-dark">
               <tr>
                  <th class="id">아이디</th>
                  <th class="name">이름</th>
                  <c:if test="${admin}">
                     <th class="prpt">권한</th>
                  </c:if>
                  <th class="del">탈퇴</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${cus}" var="list">
                  <tr class="thead-light">
                     <td style="vertical-align: middle">${list.id}</td>
                     <td style="vertical-align: middle">${list.name }</td>
                     <c:if test="${admin }">
                        <td style="text-align: center">
                           <button class="btn btn-outline-success"
                              onclick="grant('${list.id}', 'customer')">권한 부여</button>
                        </td>
                     </c:if>
                     <td style="text-align: center">
                        <button class="btn btn-outline-danger"
                           onclick="deleteMember('${list.id}')">회원 탈퇴</button>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <br> <br>
      </div>

   </div>
   <div class="back">
      <button type="button" class="btn btn-outline-success"
         onclick="location.href='reviewlist.do'">메인화면</button>
   </div>
   <div class="container-fluid footer">
      <jsp:include page="footer.jsp" />
   </div>

</body>
<script>
   function grant(id, property) {
      if (property == 'manager') {
         var isOk = confirm("권한을 제거하시겠습니까?");

      } else {
         var isOk = confirm("권한을 부여하시겠습니까?");

      }
      if (isOk == true) {
         document.location.href = "membergrant.do?id=" + id + "&&property="
               + property;
      }
      return;
   }

   function deleteMember(id) {
      var isOk = confirm("해당 id의 모든 게시글이 삭제됩니다. 탈퇴시키시겠습니까?");
      if (isOk == true) {
         document.location.href = "membergrantdelete.do?id=" + id;
      }
      return;
   }
</script>

</html>
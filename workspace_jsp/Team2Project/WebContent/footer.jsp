<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<% long date =System.currentTimeMillis(); %>
<footer style="background-color: gray; color:#ffffff">
      <div class="container">
         <br>
         
         <div class="row">
            <div class="col-sm-2" ><img alt="show.pg" src="show.jpg" style="width: 150px; height: 150px"></div>
            <div class="col-sm-4"><h4></h4><p> 명칭: 주식회사 2team | 등록번호: 경기 아51514 | 등록연월일: 2020. 6. 11 | 제호: 2team
발행인: 홍승현 | 편집인: 홍승현 | 발행소: 강님  분당구 강남대로 331번길 8, 7층
발행연월일: 2020 6. 11 | 전화번호: 02 - 6393 - 1111 | E-mail: clswjfgks@naver.com</p></div>
            <div class="col-sm-2"><h4 style="text-align: center;">내비게이션</h4>
               <div class="list-group">
                  <a href="http//www.naver.com" class="list-group-item list-group-item-info">삼성 </a>
                  <a href="https://www.11st.co.kr" class="list-group-item list-group-item-success">11번가</a>
                  <a href="#" class="list-group-item list-group-item-danger">야놀자</a>
               </div>
            </div>
            
            <div class="col-sm-2"><h4 style="text-align: center;">SNS</h4>
               <div class="list-group">
                  <a href="#" class="list-group-item list-group-item-info">페이스북</a>
                  <a href="#" class="list-group-item list-group-item-success">유튜브</a>
                  <a href="#" class="list-group-item list-group-item-danger">네이버 TV</a>
               </div>
            </div>
            
            <div class="col-sm-2"><h4 style="text-align: center;"><span class="glyphicon glyphicon-ok"></span>&nbsp By TEAM 2 PROJECT</h4></div>
         </div>
      </div>
   </footer>



</div>
</footer>
</body>
</html>
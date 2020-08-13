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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<style type="text/css">
   .th-center{
      text-align: center;
   }
</style>

</head>
<body>

   <div class="container">
      <div class="row text-center">
         <h1>회원리스트</h1>
      </div>
        <div class="row">
         <table class="table">
            <thead>
               <tr>
                  <th class="th-center">회원번호</th>
                  <th class="th-center">아이디</th>
                  <th class="th-center">이름</th>
                  <th class="th-center">전화번호</th>
                  <th class="th-center">이메일</th>
                  <th class="th-center">관리</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${list}" var="dto">
                  <tr>
                     <td>${dto.memberNo}</td>   
                     <td>${dto.memberId}</td>    
                     <td>${dto.memberName}</td>
                     <td>${dto.memberPhone}</td>
                     <td>${dto.memberEmail}</td>
                     <td><a href="/member/read/${dto.memberNo}" class="btn btn-info" role="button">자세히 보기</a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div> <!-- class = row -->
      <div class = "row text-center">
      <nav aria-label="Page navigation">
           <ul class="pagination">
                <li>
                   
                  <a href="/member/list?curPage=${mto.curPage> 1? mto.curPage-1 : 1}" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                 </a>
                </li>
                
                <li>
                   <c:forEach begin="${mto.beginPageNum}" end="${mto.stopPageNum}" var="page">
                       <li class= "${mto.curPage==page?'active':''}"><a href="/member/list?curPage=${page}">${page}</a></li>
                    </c:forEach>
    
                </li>
 
                <li>
                  <a href="/member/list?curPage=${mto.curPage<mto.totalPage? mto.curPage+1 : mto.curPage }" aria-label="Next">
                   <span aria-hidden="true">&raquo;</span>
                  </a>
               </li>
          </ul>
   </nav>
      </div>
   </div> <!-- class = row -->
   <div class="row">
   <form target="_blank" action="/member/searchlist" method="get">
   <div class="input-group">
   <span class="input-group-addon">
   <select name="searchType">
      <option value="disabled">검색 기준</option>
       <option value="memberId">아이디</option>
        <option value="memberName">이름</option>
          <option value="memberEmail">이메일</option>
   </select>
   </span>
   
   <input class="form-control" name="keyword">
   <span class="input-group-btn">
   <button class="btn btn-info">검색</button>   
   </span>
   </div> 
   </form>
   </div>
   
  </div> <!-- class = container -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<!-- daum 도로명주소 찾기 api --> 
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> 
<script type="text/javascript"> 

//모든 공백 체크 정규식 
var empJ = /\s/g; 

// 비밀번호 정규식 
var pwJ = /^[A-Za-z0-9]{4,12}$/; 
// 이름 정규식
var nameJ = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/; 
// 이메일 검사 정규식
var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; 
// 휴대폰 번호 정규식
var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
/^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/ 

var birthJ = false; 
var address = $('#memberAddress_2'); 
$(document).ready(function() { 
	var address = $('#memberAddress_2'); 

      $('form').on('submit',function(){
           var inval_Arr = new Array(8).fill(false);
  
          // 이름 정규식
           if (nameJ.test($('#memberName').val())) {
                inval_Arr[2] = true;
                } else {
                 inval_Arr[2] = false; 
                 alert('이름을 확인하세요.'); 
                 return false; } 
           
           // 생년월일 정규식
            if (birthJ) {
               console.log(birthJ);
                inval_Arr[3] = true;
                 } else {
                      inval_Arr[3] = false;
                      alert('생년월일을 확인하세요.');
                      return false; 
                      } 
            // 이메일 정규식 
            if (mailJ.test($('#memberEmail').val())){
                console.log(phoneJ.test($('#memberEmail').val()));
                inval_Arr[4] = true; 
               } else { 
                inval_Arr[4] = false; 
                alert('이메일을 확인하세요.'); 
                return false; } 
            // 휴대폰번호 정규식
             if (phoneJ.test($('#memberPhone').val())) {
                  console.log(phoneJ.test($('#memberPhone').val())); 
                  inval_Arr[5] = true; } else { inval_Arr[5] = false; 
                  alert('휴대폰 번호를 확인하세요.'); 
                  return false; } 
             //성별 확인 
             if(member.memberGender[0].checked==false&&member.memberGender[1].checked==false){ 
                 inval_Arr[6] = false; 
                 alert('성별을 확인하세요.'); 
                 return false; 
                 } else{ 
                     inval_Arr[6] = true; 
                     } 
             //주소확인 
             if(address.val() == ''){
              inval_Arr[7] = false; 
              alert('주소를 확인하세요.'); 
              return false; 
              }else 
              inval_Arr[7] = true; 
              //전체 유효성 검사
               var validAll = true; 
               for(var i = 2; i < inval_Arr.length; i++){
                  if(inval_Arr[i] == false){
                      validAll = false;
                       } 
                  } 
               if(validAll == true){ // 유효성 모두 통과 
                   alert('수정이 정상적으로 처리되었습니다.'); } else { 
                       alert('정보를 다시 확인하세요.') }
                });

      
      
       //이름에 특수문자 들어가지 않도록 설정
        $("#memberName").blur(function() {
             if (nameJ.test($(this).val())) {
                  console.log(nameJ.test($(this).val()));
                  $("#name_check").text(''); 
                 } else {
                  $('#name_check').text('한글 2~4자 이내로 입력하세요. (특수기호, 공백 사용 불가)'); 
                   $('#name_check').css('color', 'red');
                    } 
             }); 

       

        //이름에 특수문자 들어가지 않도록 설정
        $("#memberHolder").blur(function() {
             if (nameJ.test($(this).val())) {
                  console.log(nameJ.test($(this).val()));
                  $("#Holder_check").text(''); 
                 } else {
                  $('#Holder_check').text('한글 2~4자 이내로 입력하세요. (특수기호, 공백 사용 불가)'); 
                   $('#Holder_check').css('color', 'red');
                    } 
             });
        
        
        $("#memberEmail").blur(function() {
             if (mailJ.test($(this).val())) {
                  $("#email_check").text('');
                   } else {
                        $('#email_check').text('이메일 양식을 확인해주세요.');
                        $('#email_check').css('color', 'red'); 
                        } 
             }); 
        // 생일 유효성 검사 
        var birthJ = false; 
        // 생년월일 birthJ 유효성 검사 
        $('#memberBirth').blur(function(){
             var dateStr = $(this).val(); 
             var year = Number(dateStr.substr(0,4)); // 입력한 값의 0~4자리까지 (연) 
             var month = Number(dateStr.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월) 
             var day = Number(dateStr.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일) 
             var today = new Date(); // 날짜 변수 선언 var 
             yearNow = today.getFullYear(); // 올해 연도 가져옴 
             if (dateStr.length <=8) { 
                 // 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다. 
                 if (year > yearNow || year < 1900 ){ 
                     $('#birth_check').text('생년월일을 확인해주세요'); 
                     $('#birth_check').css('color', 'red'); } 
                 else if (month < 1 || month > 12) { 
                     $('#birth_check').text('생년월일을 확인해주세요 '); 
                     $('#birth_check').css('color', 'red'); 
                     }else if (day < 1 || day > 31) {
                          $('#birth_check').text('생년월일을 확인해주세요 ');
                          $('#birth_check').css('color', 'red'); 
                          }else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
                               $('#birth_check').text('생년월일을 확인해주세요 '); 
                               $('#birth_check').css('color', 'red'); 
                               }else if (month == 2) {
                                    var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                                    if (day>29 || (day==29 && !isleap)) { 
                                    $('#birth_check').text('생년월일을 확인해주세요 '); 
                                    $('#birth_check').css('color', 'red'); 
                                    }else{ 
                                    $('#birth_check').text(''); 
                                    birthJ = true; 
                                    } 
                                    }else{ 
                                    $('#birth_check').text('');
                                    birthJ = true; 
                                    }//end of if
                  }else{ 
                     //1.입력된 생년월일이 8자 초과할때 : auth:false 
                     $('#birth_check').text('생년월일을 확인해주세요 '); 
                     $('#birth_check').css('color', 'red'); } }); 
                     //End of method /* 
                     
                     
                     // 생일 유효성 검사 
        var birthJ = false; 
      
                     
                     // 휴대전화
                      $('#memberPhone').blur(function(){ 
                          if(phoneJ.test($(this).val())){ 
                              console.log(nameJ.test($(this).val()));
                              $("#phone_check").text(''); 
                              } else { 
                              $('#phone_check').text('휴대폰번호를 확인해주세요 ');
                              $('#phone_check').css('color', 'red'); 
                              } 
                          }); 
                      }) ;
                      //우편번호 찾기 버튼 클릭시 발생 이벤트 
                      function execPostCode() { 
                      new daum.Postcode({ 
                         oncomplete: function(data) { 
                          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 
                          
                          // 도로명 주소의 노출 규칙에 따라 주소를 조합한다. 
                          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다. 
                          var fullRoadAddr = data.roadAddress; // 도로명 주소 변수 
                          var extraRoadAddr = ''; // 도로명 조합형 주소 변수 
                          // 법정동명이 있을 경우 추가한다. (법정리는 제외) 
                          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다. 
                          if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                               extraRoadAddr += data.bname; 
                               } 
                          // 건물명이 있고, 공동주택일 경우 추가한다. 
                          if(data.buildingName !== '' && data.apartment === 'Y'){
                               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName); 
                               } 
                          // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다. 
                          if(extraRoadAddr !== ''){ 
                              extraRoadAddr = ' (' + extraRoadAddr + ')'; 
                              } 
                          // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다. 
                          if(fullRoadAddr !== ''){ 
                              fullRoadAddr += extraRoadAddr; 
                          } 
                          // 우편번호와 주소 정보를 해당 필드에 넣는다. 
                          console.log(data.zonecode); 
                          console.log(fullRoadAddr); 
                          /* var a = console.log(data.zonecode); 
                          var b = console.log(fullRoadAddr); 
                          if(a == null || b = null){ 
                              alert("주소를 확인하세요."); 
                              return false; } */ 
                              $("[name=memberZipcode]").val(data.zonecode); 
                              $("[name=memberAddress_1]").val(fullRoadAddr);
                               document.getElementById('memberZipcode').value = data.zonecode; //5자리 새우편번호 사용 
                               document.getElementById('memberAddress_1').value = fullRoadAddr; 
                               //document.getElementById('memberAddress_2').value = data.jibunAddress; 
                               } 
                      }).open(); 
                      } </script> 
                      </head>
<body>
   
<div class="container">
  <div class="row text-center">
    <h1>글 수정</h1>
  </div>
  <div class="row">
    <form action="/member/update" method="post" role="form" id="usercheck" name="member" autocomplete="off">
        <input type="hidden" name="memberNo" value="${to.memberNo}">
        
        <table border="1" width="400px">
        
        <tr>
         <div class="form-group">
        <td><label for="memberId" >아이디</label></td>
          <td><input readonly value="${to.memberId}" name="memberId" id="memberId" class="form-control"></td>       
         </div>   
         </tr>
         
         
            <tr>
         <div class="form-group">
        <td><label for="memberName">이름</label></td>
          <td><input value="${to.memberName}" name="memberName" id="memberName" class="form-control"></td>       
         <div class="check_font" id="name_check"></div>
         </div>   
         </tr>
         
            <tr>
         <div class="form-group">
        <td><label for="memberBirth">생년월일</label></td>
          <td><input value="${to.memberBirth}" name="memberBirth" id="memberBirth" class="form-control">
          </td>          
         </div>   
           <div class="check_font" id="birth_check"></div>
         </tr>
         
            <tr>
         <div class="form-group">
        <td><label for="memberEmail">이메일</label></td>
          <td><input value="${to.memberEmail}" name="memberEmail" id="memberEmail" class="form-control"></td>       
          <div class="check_font" id="email_check"></div> 
         </div>   
         </tr>
         
            <tr>
         <div class="form-group">
        <td><label for="memberTel">일반전화</label></td>
          <td><input value="${to.memberTel}" name="memberTel" id="memberTel" class="form-control"></td>       
         
         </div>   
         </tr>
            <tr>
         <div class="form-group">
        <td><label for="memberPhone">휴대전화</label></td>
          <td><input value="${to.memberPhone}" name="memberPhone" id="memberPhone" class="form-control"></td>       
         <div class="check_font" id="phone_check"></div>
         </div>   
         </tr>
         
             <tr>
         <div class="form-group">
        <td><label for="memberGender">성별</label></td>
          <td>  <input type="checkbox" id="memberGender" name="memberGender" value="남">남 
                       <input type="checkbox" id="memberGender" name="memberGender" value="여">여 </td>               
         </div>   
         </tr>
         
                 <tr>
         <div class="form-group">
        <td><label for="memberZipcode">우편번호</label></td>
          <td><input value="${to.memberZipcode}" class="form-control" name="memberZipcode" id="memberZipcode" type="text" readonly="readonly" /></td>       
         </div>   
         </tr>
         
         
            <tr>
         <div class="form-group">
        <td><label for="memberAddress_1">주소</label></td>
          <td><input value="${to.memberAddress_1}" class="form-control" name="memberAddress_1" id="memberAddress_1" type="text" readonly="readonly" /></td>       
         </div>   
         </tr>
         
            <tr>
         <div class="form-group">
        <td><label for="memberAddress_2">상세주소</label></td>
          <td><input value="${to.memberAddress_2}" name="memberAddress_2" id="memberAddress_2" class="form-control"></td>       
         </div>   
         </tr>
         
            <tr>
         <div class="form-group">
        <td><label for="memberPetName">반려동물 이름</label></td>
          <td><input value="${to.memberPetName}" name="memberPetName" id="memberPetName" class="form-control"></td>       
         </div>   
         </tr>
            <tr>
         <div class="form-group">
        <td><label for="memberPetAge">반려동물 나이</label></td>
          <td><input value="${to.memberPetAge}" name="memberPetAge" id="memberPetAge" class="form-control"></td>       
         </div>   
         </tr>
         
            <tr>
         <div class="form-group">
        <td><label for="memberHolder">예금주</label></td>
          <td><input value="${to.memberHolder}" name="memberHolder" id="memberHolder" class="form-control"></td>       
          <div class="check_font" id="Holder_check"></div> 
         </div>   
         </tr>
         
         <tr>
         <div class="form-group">
        <td><label for="memberBank">은행명</label></td>
          <td><input value="${to.memberBank}" name="memberBank" id="memberBank" class="form-control"></td>       
         </div>   
         </tr>
         
         <tr>
         <div class="form-group">
        <td><label for="memberAccount">계좌번호</label></td>
          <td><input value="${to.memberAccount}" name="memberAccount" id="memberAccount" class="form-control"></td>       
         </div>   
         </tr>
         
   
         
         
         
         </table>        
    </form>
    <div class="form-group">
        <button class="btn btn-primary" id="updatebtn">수정</button>
        <button class="btn btn-primary" id="listbtn">목록</button>
         <button type="button" class="btn btn-primary" onclick="execPostCode();">
                       <i class="fa fa-search"></i>주소수정</button> 
    </div>
    </div>
</div>


<script type="text/javascript">

  $(document).ready(function(){
      $("#updatebtn").click(function(){
          $("form").submit();  
      });
      
      $("#listbtn").click(function(){
         location.assign("/member/list");
      });
   });
</script>

</body>
</html>
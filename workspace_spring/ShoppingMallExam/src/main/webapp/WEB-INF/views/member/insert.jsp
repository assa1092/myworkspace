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
<!-- daum 도로명주소 찾기 api --> 
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> 
<style type="text/css"> 
td{ border:1px solid #000000; 
border-collapse:collapse; 
} 
</style> 
<script type="text/javascript"> 

//모든 공백 체크 정규식 
var empJ = /\s/g; 
//아이디 정규식 
var idJ = /^[a-z0-9][a-z0-9_\-]{4,19}$/; 
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
//아이디 중복확인 
$("#memberId").blur(function() {
	if($('#memberId').val()==''){ 
	   $('#id_check').text('아이디를 입력하세요.'); 
$('#id_check').css('color', 'red'); 
} else if(idJ.test($('#memberId').val())!=true){ 
	$('#id_check').text('4~12자의 영문, 숫자만 사용 가능합니다.'); 
    $('#id_check').css('color', 'red'); } 
    else if($('#memberId').val()!=''){ 
    var memberId=$('#memberId').val(); 
    $.ajax({ 
    async : true, 
    type : 'POST', 
    data : memberId,
	url : 'idcheck', 
	dateType: 'json', 
	contentType: "application/json; charset=UTF-8", 
	success : function(data) { 
		if(data.cnt > 0){
			 $('#id_check').text('중복된 아이디 입니다.'); 
			 $('#id_check').css('color', 'red'); 
			 $("#usercheck").attr("disabled", true); 
			 }else{
	    if(idJ.test(memberId)){
		     $('#id_check').text('사용가능한 아이디 입니다.');
		     $('#id_check').css('color', 'blue');
		     $("#usercheck").attr("disabled", false); } 
	    else if(memberId==''){
	    $('#id_check').text('아이디를 입력해주세요.');
	    $('#id_check').css('color', 'red'); 
	    $("#usercheck").attr("disabled", true); 
	    } 
	    else{ 
		   $('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다."); 
		   $('#id_check').css('color', 'red'); $("#usercheck").attr("disabled", true); 
		   } 
		   } 
		   } 
	   });//ajax///
	    }//else if
     });//blur
      $('form').on('submit',function(){
           var inval_Arr = new Array(8).fill(false);
           if (idJ.test($('#memberId').val())) {
               inval_Arr[0] = true; } else { inval_Arr[0] = false;
               alert('아이디를 확인하세요.'); return false; 
             } 
           // 비밀번호가 같은 경우 && 비밀번호 정규식
          if (($('#memberPw').val() == ($('#memberPw2').val()))
                   && pwJ.test($('#memberPw').val())) {
               inval_Arr[1] = true;
            } else { inval_Arr[1] = false; alert('비밀번호를 확인하세요.');
             return false; 
             } 
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
               for(var i = 0; i < inval_Arr.length; i++){
                  if(inval_Arr[i] == false){
                      validAll = false;
                       } 
                  } 
               if(validAll == true){ // 유효성 모두 통과 
                   alert('PETHROOM 가족이 되어주셔 감사합니다.'); } else { 
                       alert('정보를 다시 확인하세요.') }
                });
       $('#memberId').blur(function() {
            if (idJ.test($('#memberId').val())) {
                 console.log('true'); 
                 $('#id_check').text(''); 
                 } else { 
                 console.log('false'); $('#id_check').text('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.'); 
                 $('#id_check').css('color', 'red'); 
                 } 
            }); 
       $('#memberPw').blur(function() {
            if (pwJ.test($('#memberPw').val())) {
                console.log('true'); 
                $('#pw_check').text(''); 
                } else { 
                 console.log('false'); 
                 $('#pw_check').text('4~12자의 숫자 , 문자로만 사용 가능합니다.');
                 $('#pw_check').css('color', 'red'); 
                 } 
            }); 
       //1~2 패스워드 일치 확인 
       $('#memberPw2').blur(function() { 
           if ($('#memberPw').val() != $(this).val()) {
                $('#pw2_check').text('비밀번호가 일치하지 않습니다.'); 
                $('#pw2_check').css('color', 'red'); 
                } else { 
                    $('#pw2_check').text(''); 
                    } 
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
                      }); 
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
                      <article class="container"> 
                      <div class="page-header"> 
                      <div class="col-md-6 col-md-offset-3"> 
                      <h3>회원가입</h3>
                      <br> 
                      <p><img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수">필수입력사항</p>
                      </div> 
                      </div> 
                      <div class="col-sm-6 col-md-offset-3"> 
                     <section id="container">
                    <div id="container_box">
                   <section id="content">
                 <form action="insert" method="post" role="form" id="usercheck" name="member" autocomplete="off">
                      <div class="form-group"> 
                      <label for="id">아이디 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></label> 
                      <input type="text" class="form-control" id="memberId" name="memberId" placeholder="ID"> 
                      <div class="check_font" id="id_check"></div> 
                      </div>
          
                       <div class="form-group"> 
                       <label for="pw">비밀번호 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></label> 
                       <input type="password" class="form-control" id="memberPw" name="memberPw" placeholder="PASSWORD"> 
                       <div class="check_font" id="pw_check"></div> 
                       </div> 
                       <div class="form-group"> 
                       <label for="pw2">비밀번호 확인 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></label> 
                       <input type="password" class="form-control" id="memberPw2" name="memberPw2" placeholder="Confirm Password"> 
                       <div class="check_font" id="pw2_check"></div> 
                       </div> 
                       <div class="form-group"> 
                       <label for="memberName">이름 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></label> 
                       <input type="text" class="form-control" id="memberName" name="memberName" placeholder="Name"> 
                       <div class="check_font" id="name_check"></div> 
                       </div> 
                       <div class="form-group"> 
                       <label for="memberBirth">생년월일 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></label> 
                       <input type="tel" class="form-control" id="memberBirth" name="memberBirth" placeholder="ex) 19990101"> 
                       <div class="check_font" id="birth_check"></div> 
                       </div> 
                       <div class="form-group"> 
                       <label for="memberEmail">이메일 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></label> 
                       <input type="email" class="form-control" id="memberEmail" name="memberEmail" placeholder="E-mail"> 
                       <div class="check_font" id="email_check"></div> 
                       </div> 
                       <div class="form-group"> 
                       <label for="memberTel">일반 전화 ('-'없이 번호만 입력해주세요)</label> 
                       <input type="tel" class="form-control" id="memberTel" name="memberTel" placeholder="Tel Number"> 
                       <div class="check_font" id="Tel_check"></div> 
                       </div> 
                       <div class="form-group"> 
                       <label for="memberPhone">휴대 전화 ('-'없이 번호만 입력해주세요) <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></label> 
                       <input type="tel" class="form-control" id="memberPhone" name="memberPhone" placeholder="Phone Number"> 
                       <div class="check_font" id="phone_check"></div> 
                       </div> 
                       <div class="form-group"> <label for="memberGender">성별 </label> 
                       <input type="checkbox" id="memberGender" name="memberGender" value="남">남 
                       <input type="checkbox" id="memberGender" name="memberGender" value="여">여 
                       </div> 
                       
                       <label for="memberZipcode">주소 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></label> 
                       <div class="form-group">
                       <input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="memberZipcode" id="memberZipcode" type="text" readonly="readonly" > 
                       <button type="button" class="btn btn-default" onclick="execPostCode();">
                       <i class="fa fa-search"></i> 우편번호 찾기</button> 
                       </div> 
                       <div class="form-group"> 
                       <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="memberAddress_1" id="memberAddress_1" type="text" readonly="readonly" /> 
                       </div> 
                       <div class="form-group"> 
                       <input class="form-control" placeholder="상세주소" name="memberAddress_2" id="memberAddress_2" type="text" /> 
                       </div>
                       
                       <h3>추가정보 </h3>
                       
                          <div class="form-group"> 
                       <label for="memberPetName">반려동물 이름</label> 
                       <input type="text" class="form-control" id="memberPetName" name="memberPetName"> 
                    
                       </div> 
                          <div class="form-group"> 
                       <label for="memberPetAge">반려동물 나이</label> 
                       <input type="text" class="form-control" id="memberPetAge" name="memberPetAge"> 
                       </div>
                     
                       
                       <h3>환불계좌 정보 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif" alt="필수"></h3>
                      
                       <div class="form-group"> 
                       <label for="memberHolder">예금주</label> 
                       <input type="text" class="form-control" id="memberHolder" name="memberHolder"> 
                       <div class="check_font" id="Holder_check"></div> 
                       </div> 
                          
                       <div class="form-group"> 
                       <label for="memberBank">은행명</label> 
                       <br>
                       <select id="memberBank" name="memberBank" fw-filter="isFill" fw-label="은행명" fw-msg="" style="height: 34px; width: 100%">                     
                       <option value="" selected="selected">- 은행선택 -</option>
                       <option value="산업은행">산업은행</option>
                       <option value="기업은행">기업은행</option>
                       <option value="국민은행">국민은행</option>
                       <option value="하나(외환)은행">하나(외환)은행</option>
                       <option value="수협중앙회">수협중앙회</option>
                       <option value="농협중앙회">농협중앙회</option>
                       <option value="농협개인">농협개인</option>
                       <option value="농협">농협</option>
                       <option value="우리은행">우리은행</option>
                       <option value="유안타증권">유안타증권</option>
                       <option value="KB증권">KB증권</option>
                       <option value="SC제일은행">SC제일은행</option>
                       <option value="미래에셋증권">미래에셋증권</option>
                       <option value="대우증권">대우증권</option>
                       <option value="삼성증권">삼성증권</option>
                       <option value="한국투자증권">한국투자증권</option>
                       <option value="신한은행">신한은행</option>
                       <option value="교보증권">교보증권</option>
                       <option value="하이투자증권">하이투자증권</option>
                       <option value="현대차증권">현대차증권</option>
                       <option value="SK증권">SK증권</option>
                       <option value="대신증권">대신증권</option>
                       <option value="한화증권">한화증권</option>
                       <option value="하나대투증권">하나대투증권</option>
                       <option value="신한금융투자">신한금융투자</option>
                       <option value="동부증권">동부증권</option>
                       <option value="유진투자증권">유진투자증권</option>
                       <option value="메리츠증권">메리츠증권</option>
                       <option value="카카오페이증권">카카오페이증권</option>
                       <option value="NH투자증권">NH투자증권</option>
                       <option value="신영증권">신영증권</option>
                       <option value="케이뱅크">케이뱅크</option>
                       <option value="카카오뱅크">카카오뱅크</option>
                       <option value="OK저축은행">OK저축은행</option>
                       <option value="대구은행">대구은행</option>
                       <option value="부산은행">부산은행</option>
                       <option value="광주은행">광주은행</option>
                       <option value="제주은행">제주은행</option>
                       <option value="전북은행">전북은행</option>
                       <option value="경남은행">경남은행</option>
                       <option value="모건스탠리은행">모건스탠리은행</option>
                       <option value="씨티은행">씨티은행</option>
                       <option value="유에프제이은행">유에프제이은행</option>
                       <option value="미즈호코퍼레이트은행">미즈호코퍼레이트은행</option>
                       <option value="미쓰비시도쿄은행">미쓰비시도쿄은행</option>
                       <option value="뱅크오브아메리카">뱅크오브아메리카</option>
                       <option value="우체국">우체국</option>
                       <option value="신용보증기금">신용보증기금</option>
                       <option value="기술신용보증기금">기술신용보증기금</option>
                       <option value="하나은행">하나은행</option>
                       <option value="농협회원조합">농협회원조합</option>
                       <option value="도이치은행">도이치은행</option>
                       <option value="상호저축은행">상호저축은행</option>
                       <option value="새마을금고">새마을금고</option>
                       <option value="수출입은행">수출입은행</option>
                       <option value="신용협동조합">신용협동조합</option>
                       <option value="홍콩상하이은행(HSBC)">홍콩상하이은행(HSBC)</option>
                       <option value="에이비엔암로은행">에이비엔암로은행</option>
                       <option value="산림조합">산림조합</option>
                       <option value="한국주택금융공사">한국주택금융공사</option>
                       <option value="서울보증보험">서울보증보험</option>
                       <option value="경찰청">경찰청</option>
                       <option value="금융결제원">금융결제원</option>
                       </select>
                        </div> 
                        
                       <div class="form-group"> 
                       <label for="memberAccount">계좌번호</label> 
                       <input type="text" class="form-control" id="memberAccount" name="memberAccount">   
                       </div> 
                              
                        <button type="submit" id="insert_btn" name="insert_btn">회원가입</button>
                      
                       </form>
                       </section>
                       </div>
                       </section>
                       </div>
                       </article>           
                       </body>
                       </html>
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
<script src ="/resources/js/uploadfn.js" type="text/javascript"></script>

<title>Insert title here</title>
<style type="text/css">
	.fileDrop{
		width : 80%;
		height : 200px;
		border : 1px solid red;
		margin : auto;
	}
	
	.uploadedList {
		margin-top : 50px;
	}
	
	/* 앞의 점 없애기 */
	.uploadedList li{
		list-style : none;
	}
	.orifilename {
		overflow : hidden;
		white-space : nowrap;
		text-overflow : ellipsis;
	}

</style>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<h1>글 자세히 보기</h1>
		</div>
		
		<div class="row">
			<div class="form-group">
				<label for="title" >제목</label>
				<input readonly value="${vo.title }" class="form-control">
			</div>
			<div class="form-group">
				<label for="writer" >작성자</label>
				<input readonly value="${vo.writer}" class="form-control">
			</div>	
			<div class="form-group">
				<label for="content" >내용</label>
				<textarea readonly rows="5" class="form-control">${vo.content}</textarea>	
			</div>	
			
			
			<div class="form-group">
				<label>첨부파일</label>
				<ul class="uploadedList clearfix">
					
				</ul>
			</div>	
		</div><!--  class= row -->
		
		<div class="row">
			<div class="form-group">
				<button class="btn btn-info" id="reply_form">댓글</button>
				<button class="btn btn-warning" id="update">수정</button>
				<button class="btn btn-danger" id="delete">삭제</button>
				<button class="btn btn-primary" id="list">목록</button>
			</div>
		</div><!-- class=row -->
		
		<!-- 댓글 작업.... -->
		<div class="row">
		<!-- collapse 댓글버튼 누르면 댓글 작성화면 나오게.... -->
		<!-- class = collapse를 넣어서 나왔다 숨겼다를 할 수 있다. -->
			<div id="myCollapse" class="collapse">
				<div class="form-group">
					<label for="replyer">작성자</label>
					<input class="form-control" id="replyer">
				</div>
				
				<div class="form-group">
					<label for="replytext">내용</label>
					<input class="form-control" id="replytext">
				</div>
				
				<div class="form-group">
					<button id="replyInsertBtn" class="btn btn-primary">댓글 등록</button>
				</div>
			</div><!-- class = collapse -->
		</div><!-- class = row -->
		
		<!-- 덮어쓰기 할꺼라 없는거나 마찬가지 -->
		<div id="replies" class="row">
			<div class="panel panel-success">
				<div class="panel-heading">
					<span>rno: 3 </span>, <span>작성자 : 홍길동</span>
					<!-- class="pull-right" 오른쪽으로 붙게... -->
					<span class="pull-right">2020년07월07일...</span>
				</div>
				<div class="panel-body">
					<p>댓글 내용입니다</p>
					<button data-name="홍길동" data-rno="3" class="btn btn-warning btn-xs replymodify">수정</button>
					<button data-rno="3" class="btn btn-danger btn-xs replydelete">삭제</button>
				</div>
			</div>
		</div><!-- class = row -->
		
	</div><!-- class = container -->

	<div class="row">
	<!-- static 값을 주면 정상적인 방식을 통해서만 모달을 닫을 수 있다. -->
		<div data-backdrop="static" id="myModal" class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-rno">rno 데이터</h4>
					</div>
					<div class="modal-body">
						<p class="modal-replyer">홍길동</p>
						<input value="댓글내용입니다" class="form-control modal-replytext"/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning modal-update-btn" 
								data-dismiss="modal">댓글수정</button>
						
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	</div>





	<%--
			<div class="panel panel-success">
				<div class="panel-heading">
					<span>rno: 3 </span>, <span>작성자 : 홍길동</span>
					<!-- class="pull-right" 오른쪽으로 붙게... -->
					<span class="pull-right">2020년07월07일...</span>
				</div>
				<div class="panel-body">
					<p>댓글 내용입니다</p>
					<button class="btn btn-warning btn-xs replymodify">수정</button>
					<button class="btn btn-danger btn-xs replydelete">삭제</button>
				</div>
			</div>
		// 복사후 띄어쓰기 없이 한줄로 그대로 붙여서 넣기
		// var str= ''; 작은 따옴표 사이에 복사해서넣기...""는 다른 "" 때문에 충돌난다.
		
		// 동적으로 바뀌는 값에다가 '' 감싸기 rno = '3'
		// 그리고 앞뒤에 ++ 넣어준다...  '+3+'
		// 3을 지우고 동적으로 변하는 값을 넣어준다...
		// ajax로 받아온 데이터를 반복문으로... data[i]["rno"], data[i]["replyer"]
		// 수정, 삭제 버튼 누르면 rno 가지고 가야하기때문에
		// data-rno = "'+data[i]["rno"]+'" 커스터마이징(?)
	 --%>
	
	
	
	<script type="text/javascript">

		
	
		// script안에서...var 를 안붙이면 전역변수로 사용할수있다...
		var bno = ${vo.bno};	

		// 글 자세히 보기로 들어오면 원글에 달린 댓글 가져온다..
		getList(bno);
		
		$(document).ready(function(){

			// 글 자세히 보기로 들어오면 바로 첨부파일 보이게...
			// insert.jsp 에서 복사해와서 지우는 아이콘만 삭제...
			// 파일이 여거래라 배열로 받고...
			// result를 다
			$.getJSON("/getAttach/"+bno, function(arr){

				for(var i=0; i < arr.length;i++){
					
					var str ='<li class="col-xs-2">';

					str += '<a href="/displayfile?filename='+getImageLink(arr[i])+'">';

					// 이미지 파일이면 썸네일 만들고
					// 아니면 기본 아이콘으로 보이게
					if(checkImage(arr[i])){
						str += '<img src ="/displayfile?filename='+arr[i]+'"/>';
					} else {
						str += '<img src = "/resources/show.png"/>';
					}

					str += '</a>';
					str += '<p class="orifilename">';

					
					str += getOriginalName(arr[i]);
					str += '</p>';
					str += '</li>';	


					// 새로운것도 이이지게끔...append
					// 덮어쓰기는 .html 
					$(".uploadedList").append(str);	
				}
			
			});
			
			// 버튼을 눌렀을 때 업데이트
			$(".modal-update-btn").click(function(){
				var rno = $(".modal-rno").text();
				var replytext= $(".modal-replytext").val();

				$.ajax({
					type : 'put',	// 수정할때는 put, 삭제는 delete
					url : "/replies/" + rno,
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'PUT'
					},
					dataType : 'text',
					data : JSON.stringify({
						replytext : replytext	// 속성명 : 변수명
					}),
					success : function(result){
						if(result ==="success"){	
							// 자바스크립트에서는 자료형이 없기때문에 
							// === 하면 값과 자료형이 같은 경우를 말한다. 
							getList(bno);	// 성공했을시 댓글번호 갱신.
						}
					}
					 
				});
			});
			
		

			$("#replies").on("click", ".replydelete", function(){
				var rno = $(this).attr("data-rno");
				
				// 지금 클릭된 놈의 위, 위 요소 제거...
				// <div class="panel panel-success"> 이게 안보이게 제거
				// 화면상 에서만...
				// $(this).parent().parent().remove();

				$.ajax({
					type : 'delete',
					url : "/replies",
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'DELETE'
					},
					dataType : 'text',
					data : JSON.stringify({
						rno : rno
					}),
					success : function(result){
							getList(bno);
					},
					error : function(request, status, error){
						console.log(error)
					}
				});
				
			});

			// 동적으로 만들어지는 조상태그가 아닌 정적 조상태그가 중요하다.
			// .on 사용시 바로 위의 부모태그인데..정적인태그를 선택.
			// div 또는 body tag
			$("#replies").on("click", ".replymodify", function(){
				// $(this) 지금 클릭한 요소...
				// 그 요소의 속성...$(this).attr("data-rno");
				// 그 값을 변수로 받아서 쓴다.
				var rno = $(this).attr("data-rno");
				var replyer = $(this).attr("data-name")
				var replytext = $(this).prev().text();	
				//  $(this).prev()내가 방금 누른곳의 바로 앞 태그.. 부모태그...<p>
				//  그 태그의 내용 $(this).prev().text();	
				
				$(".modal-rno").text(rno);
				$(".modal-replyer").text(replyer);
				// <input> 태그라 .val();
				$(".modal-replytext").val(replytext);

				// 댓글 수정 누르면 모달 창 보이게.
				$("#myModal").modal("show");
				
			});


			// 댓글 작성
			$("#replyInsertBtn").click(function(){
				// 댓글 작성자, 내용을 가지고 ajax 통신...
				var replyer = $("#replyer").val();
				var replytext = $("#replytext").val();
				$.ajax({
					type : 'post',
					url : '/replies',
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'POST'
					},
					dataType : 'text',
					data : JSON.stringify({
						bno : bno,			//	속성명 : 변수명
						replyer : replyer,
						replytext : replytext
					}),
					success : function(result){
						console.log(result);
						// 댓글 성공하고나면 다시 댓글 입력할수있도록
						// 작성자 내용 란 지워놓기..
						$("#replyer").val("");
						$("#replytext").val("");
						
						// 댓글 쓰고나서 등록 버튼 누르면 
						// 바로 댓글 리스트 갱신...getList(bno);
						getList(bno);
						
					},
					error : function(request, status, error){
						console.log(error);
					}
				});
	
			});
	
			// <!-- collapse 댓글버튼 누르면 댓글 작성화면 나오게.... -->
			$("#reply_form").click(function(){
				$("#myCollapse").collapse("toggle");
			});
			$("#update").click(function(){
				location.assign("/board/update/${vo.bno}");
			});
			$("#delete").click(function(){
				location.assign("/board/delete/${vo.bno}");
			});
			$("#list").click(function(){
				location.assign("/board/list");
			});
		});


		// 댓글 가져오는 작업이 여러번 생기므로 함수로 만든다.
		function getList(bno){
			// ''
			//var str= ''; 안에 복사	" " 안에 넣으면 클래스의 "" 때문에 충돌난다...
			var str= '';
			
			// JSON 파일 읽어올때...getJSON(1, 2)
			// 1. 어디로, 2.성공했을때 하는일
			$.getJSON("/replies/all/"+ bno, function(data){
				// 댓글이 여러개 달릴경우 같아져 버리기 때문에..
				// id 로 지정할 수가 없다...
				// 그래서 클래스명으로 접근한다...
				for(var i=0 ; i < data.length ; i++){
					str += '<div class="panel panel-success"><div class="panel-heading"><span>rno: '+ data[i]["rno"] +' </span>, <span>작성자 : '+ data[i]["replyer"]+'</span><span class="pull-right">'+ data[i]["updatedate"] +'</span></div><div class="panel-body"><p>'+ data[i]["replytext"]+'</p><button data-name = "'+data[i]["replyer"]+'" data-rno="'+data[i]["rno"]+'"  class="btn btn-warning btn-xs replymodify">수정</button><button data-rno="'+data[i]["rno"]+'"  class="btn btn-danger btn-xs replydelete">삭제</button></div></div>'; 
				}

				$("#replies").html(str);	
				// id가 replies의 html을 str으로 덮어씌우기...
				// 추가하고 싶으면 .append()
				
				
			});
		}

	</script>
	
</body>
</html>
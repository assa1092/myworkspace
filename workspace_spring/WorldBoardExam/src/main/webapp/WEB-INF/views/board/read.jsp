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
					<label for="title">제목</label> 
					<input value="${vo.title}" class="form-control" readonly>
				</div>
				<div class="form-group">
					<label for="writer">작성자</label> 
					<input value="${vo.title}"  class="form-control" readonly>
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea row="5" class="form-control" readonly>${vo.content}</textarea>
				</div>

			 	<div class="form-group">
					<label>첨부파일</label>
					<ul class="uploadedList clearfix">

					</ul>
				</div>
		</div>
		
		<div class="row">
			<div class="form-group">
				<button class="btn btn-info" id="reply_form">댓글</button>
				<button class="btn btn-warning" id="update">수정</button>
				<button class="btn btn-danger" id="delete">삭제</button>
				<button class="btn btn-primary" id="list">목록</button>
			</div>
		</div>
		
		
		<!-- 댓글 작업.  -->
		<div class="row">
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
			</div>
		</div>
		
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
	
	
	
	
	
	
	<script type="text/javascript">
		var bno = ${vo.bno};

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
						str += '<img src = "/resources/showshow.png"/>';
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
			

			$("#replies").on("click", ".replydelete", function(){
				var rno = $(this).attr("data-rno");

				$.ajax({
					type : 'delete',
					url : '/replies',
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
						console.log(error);
					}
				});
			});
			

			$(".modal-update-btn").click(function(){
				var rno = $(".modal-rno").text();
				var replytext = $(".modal-replytext").val();

				$.ajax({
					// 수정할때는 put, 삭제는 delete
					// 삽입은 post
					type : 'put',
					url : "/replies/"+rno,
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'PUT'
					},
					dataType : 'text',
					data : JSON.stringify({
						replytext : replytext
					}),
					success : function(result){
						if(result = "success"){
							// 자바스크립트에서는 자료형이 없기때문에 
							// === 하면 값과 자료형이 같은 경우를 말한다. 
							getList(bno);	// 성공했을시 댓글번호 갱신.
						}
					}
				});
			});


			// 동적으로 만들어지는 조상태그가 아닌 정적 조상태그가 중요하다.
			// .on 사용시 바로 위의 부모태그인데..정적인태그를 선택.
			// div 또는 body tag
			$("#replies").on("click",".replymodify",function(){
				// $(this) 지금 클릭한 요소...
				// 그 요소의 속성 data-rno ...$(this).attr("data-rno");
				// 그 값을 변수로 받아서 쓴다.
				var rno = $(this).attr("data-rno");
				var replyer = $(this).attr("data-name");
				var replytext = $(this).prev().text();
				//  $(this).prev()내가 방금 누른곳의 바로 앞 태그.. 부모태그...<p>
				//  그 태그의 내용 $(this).prev().text();

				$(".modal-rno").text(rno);
				$(".modal-replyer").text(replyer);
				$(".modal-replytext").val(replytext);	// <input> 태그라 .val();

				$("#myModal").modal("show");
			});
		

			$("#replyInsertBtn").click(function(){
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
						bno : bno,
						replyer : replyer,
						replytext : replytext
					}),
					success : function(result){
						console.log(result);

						$("#replyer").val("");
						$("#replytext").val("");
						getList(bno);
					},
					error : function(request, status, error){
						console.log(error);
					}
				});
			});

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

		function getList(bno){
			var str = '';
	
			$.getJSON("/replies/all/"+ bno, function(data){
				

				for(var i=0 ; i < data.length ; i++){
					str += '<div class="panel panel-success"><div class="panel-heading"><span>rno: '+ data[i]["rno"] +' </span>, <span>작성자 : '+ data[i]["replyer"]+'</span><span class="pull-right">'+ data[i]["updatedate"] +'</span></div><div class="panel-body"><p>'+ data[i]["replytext"]+'</p><button data-name = "'+data[i]["replyer"]+'" data-rno="'+data[i]["rno"]+'"  class="btn btn-warning btn-xs replymodify">수정</button><button data-rno="'+data[i]["rno"]+'"  class="btn btn-danger btn-xs replydelete">삭제</button></div></div>'; 
				}

				$("#replies").html(str);
				
			});
		}
	</script>
	
	

</body>
</html>
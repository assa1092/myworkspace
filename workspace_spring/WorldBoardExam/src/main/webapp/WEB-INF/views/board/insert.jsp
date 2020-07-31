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

	<div class = "container">
		<div class = "row text-center">
			<h1>글쓰기</h1>
		</div>
		
		<div class="row">
			<form action="/board/insert" method="post">
				<div class="form-group">
					<label for="title">제목</label>
					<input name="title" id="title" class = "form-control" required>
				</div>
				<div class="form-group">
					<label for="writer">작성자</label>
					<input name="writer" id="writer" class = "form-control" required>
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea name="content" id="content" class = "form-control" required></textarea>
				</div>
			</form>
			
			<div class="form-group">
				<label>업로드할 파일을 드랍시키세요.</label>
				<div class="fileDrop"></div>
					<!-- 해당 형태로 파일이 들어올 것 -->
					<ul class = "uploadedList  clearfix"></ul>
	
			</div>
			
			
			
			<div class = "form-group">
				<button class="btn btn-danger" id="insertbtn">등록</button>
				<button class="btn btn-danger" id="listbtn">목록</button>
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript">
		$(document).ready(function(){

			$(".fileDrop").on("dragenter dragover", function(event){
				event.preventDefault();
			});

			$(".fileDrop").on("drop", function(event){
				event.preventDefault();

				var files = event.originalEvent.dataTransfer.files;

				var file = files[0];

				var formData = new FormData();

				formData.append("file", file);

				$.ajax({
					type : 'post',
					url : '/uploadajax',
					dataType : 'text',
					data : formData,
					processData : false,
					contentType : false,
					success : function(result){
						console.log(result);

					/* 
						// 업로드가 되면 파일 이름이 한줄씩 나온다.
						// 이미지 화일이면 원본 화일 보여주기....
						var str = "<li><a href= '/displayfile?filename="+getImageLink(result)+"'>";
						// 화일 이름 보일때 아이콘처럼 이미지 화일 보이게
						
						// 이미지 화일 일때와 아닌때..구분
						if(checkImage(result)){		// 동적으로 변할수 있는 값이면 '' 감싸주고 양쪽에  + +.
							str += "<img src= '/displayfile?filename="+result+"' />"
							// <img src>에 화일말고도 이미지나 소스가 들어갈수도 있다
 						} else {
							str += "<img src='/resources/show.png'/>"
						}

						// 이미지 화일인지 확인하고. 
						// 원본 화일의 이름을 가져오는 함수 호출...
						str += getOriginalName(result);		
						str += "</a><a class='deletefile' href='"+result+"'><span class='glyphicon glyphicon-trash'></span></a></li>";
						//<span class='glyphicon glyphicon-trash'></span> 쓰레기통 아이콘...
					*/

						var str = '<li class="col-xs-2">';
						str += '<a href="/displayfile?filename='+getImageLink(result)+'">';

						if(checkImage(result)){
							str += '<img src ="/displayfile?filename='+result+'"/>';
						} else {
							str += '<img src = "/resources/show.png"/>';
						}

						str += '</a>';
						str += '<p class="orifilename">';

						str += '<a href="'+result+'" class="deletefile"><span class="glyphicon glyphicon-trash"></span></a>';
						str += getOriginalName(result);
						str += '</p>';
						str += '</li>';	

						$(".uploadedList").append(str);	


						
					},
				});
				
			});

			$("#insertbtn").click(function(event){
				event.preventDefault();

				var str = '';

				// 파일이 여러가지라 배열로 잡힌다.
				// .each => 반복문을 돌린다...
				$(".deletefile").each(function(index){
					// <input> 은 값을 가지고 가기위한 수단...
					// name 값이 없으면 값을 가져가지 못한다...
					// 배열이라 동적으로 변한다.....
					str +="<input name='files["+index+"]' value='"+$(this).attr("href")+"' type='hidden'>";
				});


				$("form").append(str);

				
				$("form").submit();
			});
			$("#listbtn").click(function(){
				location.assign("/board/list");
			});
			
		});
	</script>

</body>
</html>
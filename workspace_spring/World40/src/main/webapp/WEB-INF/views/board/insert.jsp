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
<script src="/resources/js/uploadfn.js" type="text/javascript"></script>

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
	
	<div class="container"><!-- class="container-fluid" 왼쪽으로 붙어서 정렬... -->
		<div class="row text-center">
			<h1>글쓰기</h1>
		</div>
		<div class="row"> <!-- class="row" 한 줄을 의미... -->
			
			<form action="/board/insert" method="post">
				<div class="form-group">
					<label for="title">제목</label><!-- for="title" 제목 클릭시 name="title"으로 포커스 가게... -->
					<input name="title" id="title" class="form-control"><!-- input 태그가 한줄로 모서리 둥글게...class="form-control" -->
					
				</div>
				<div class="form-group">
					<label for="writer">작성자</label>
					<input name="writer" id="writer" class="form-control">
				</div>
				
				<div class="form-group">
					<label for="content">내용</label>
					<textarea rows="5" name="content" id="content" class="form-control"></textarea>
				</div>		
			</form>
			
			<div class="form-group">
				<label>업로드할 파일을 드랍시키세요.</label>
				<div class="fileDrop"></div>
				<!-- 해당 형태로 파일이 들어올 것 -->
				<ul class = "uploadedList  clearfix"></ul>
				
				<!-- 단말기가 바뀔 때마다 다른 칸을 적용해라 -->
				<!-- <li class= "col-xs-2"> -->
				
				<!-- 
					
					<li class= "col-xs-2">
						<a href="#"><img src="/resources/show.png"></a>
						<p class="orifilename"><a>aaaa.txt<span class="glyphicon glyphicon-trash"></span></a></p>
					</li>
				-->
			</div>
			
			
			<div class="form-group">
				<button class="btn btn-danger" id="insertbtn">등록</button><!-- 문맥 테그 primary, warning,danger, link, default... -->
				<button class="btn btn-danger" id="listbtn">목록</button>
			</div>	
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){

			// 쓰레기통 버튼 누르면 삭제
			$(".uploadedList").on("click",".deletefile", function(event){
				event.preventDefault();

				// 지금 현재 눌러진것을 알아야 한다.
				// ajax통신후에는 누구였는지를 알수가 없다.
				var that = $(this);

				$.ajax({
					type : 'post',
					url : '/deletefile',
					dataType : 'text',
					data : {
						filename : that.attr("href")
					},
					success : function(result){
						// 부모의 부모의 속성의 li를 없앤다.
						that.parent("p").parent("li").remove();	
					}
				});	
			});


			// 이벤트를 여러개 주고 싶을때도 on을 사용한다.
			$(".fileDrop").on("dragenter dragover", function(event){
				event.preventDefault();		// dragenter, dragover 기본 기능을 막아주는것.
			});

			// 해당위치에 파일이 드랍되었을때  upload 되게...
			$(".fileDrop").on("drop",function(event){	
				event.preventDefault();

				// 드래그해서 가져온 파일들의 정보가 
				// files에 담김 여러개일수있음.
				// 드레그해서 가져온 파일을 변수로 받는다.
				var files = event.originalEvent.dataTransfer.files;	  

				// 그 파일들중 맨 처음 화일 가져온다.
				var file = files[0];	

				// FormData() 이용해서 form 태그를 만든다...
				var formData = new FormData();	
				// 파일 하나 추가...여러개 하려면 for 문으로...
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
						
						
						var str ='<li class="col-xs-2">';

						str += '<a href="/displayfile?filename='+getImageLink(result)+'">';

						// 이미지 파일이면 썸네일 만들고
						// 아니면 기본 아이콘으로 보이게
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


						// 새로운것도 이이지게끔...append
						// 덮어쓰기는 .html 
						$(".uploadedList").append(str);		 
						
					}
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
				$("form").submit();			// 클릭했을때 form 태그가...submit 된다....
			});
		});

	</script>
	
	
</body>
</html>
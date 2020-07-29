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
	.fileDrop {
		width : 80%;
		height : 200px;
		border : 1px dotted red;
	}
</style>

</head>
<body>
	<div class="fileDrop"></div>
	<div class="uploadedList">
		<p></p>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){

			$(".uploadedList").on("click", ".deletefile", function(event){
				event.preventDefault();

				var that = $(this);	
				// 지금 클릭된 것이 that으로 정해놓는다.
				// ajax 통신이 끝나면 this가 먼지 모르게된다.
				// 그래서 ajax 통신전에 정한다.

				$.ajax({
					type : 'post',
					url : '/deletefile',
					dataType : 'text',
					data : {		// 지금 클릭한 것의 속성중 href 의 값을 filename으로... 
						filename : $(this).attr("href")
					},
					success : function(result){
						alert(result);
						// 상위의 div태그를 지워라..<div class="uploadedList">
						// 업로드 시킨것을 보여주는 <div> 라 이게 지워지면 다 
						that.parent("div").remove();
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
				var files = event.originalEvent.dataTransfer.files;	  // 드레그해서 가져온 파일을 변수로 받는다.

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
						
						// 업로드가 되면 파일 이름이 한줄씩 나온다.
						// 이미지 화일이면 원본 화일 보여주기....
						var str = "<div><a href= '/displayfile?filename="+getImageLink(result)+"'>";
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
						str += "</a><a class='deletefile' href='"+result+"'><span class='glyphicon glyphicon-trash'></span></a></div>";
						//<span class='glyphicon glyphicon-trash'></span> 쓰레기통 아이콘...

						// 새로운것도 이이지게끔...append
						// 덮어쓰기는 .html
						$(".uploadedList").append(str);		 
						
					}
				});
			
			});
		});

		
		function getImageLink(result){
			if(checkImage(result)){	
				return result.substring(0,12) + result.substring(14);
			} else {
				return result;
			}
			
		}
		

		// 이미지 파일이면 두번째...'_' 언더바
		// 이미지 파일이 아니면 첫번째.. _언더바에서 가져오면 파일이름 
		function getOriginalName(filename){
			if(checkImage(filename)){

				var idx = filename.indexOf("_");	// 첫번째 _언더바 의 인덱스를 찾아서
				
				idx = filename.indexOf("_", idx+1);	// 그 다음부터 다시 두번째 _ 를 찾아서
				return filename.substring(idx+1);	// 두번째 _언더바 그 다음부터의 값을 리턴해준다.
				
			} else {
				var idx = filename.indexOf("_");
				return filename.substring(idx+1);	// +1 을 해야 '_'언더바 다음부터 나온다. 
			}
		}


		// 이미지 파일 여부 확인
		function checkImage(filename){
			var idx = filename.lastIndexOf(".");
			
			var format = filename.substring(idx+1).toUpperCase();
			
			if(format =='PNG' || format == 'JPG'|| 
					format == 'JPEG'|| format == 'GIF'){
				return true;
			} else {
				return false;
			}
			
		}
		
	
	</script>

</body>
</html>
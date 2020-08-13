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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.pagination {
	text-align: center;
	display: block;
}

.pagination>li>a {
	float: none;
	margin-left: -5px;
}

#form-seach {
	text-align: center;
}
.fileDrop {
	width: 80%;
	height: 200px;
	border: 1px solid red;
	margin: auto;
}

.uploadedList {
	margin-top: 50px;
}

.uploadedList li {
	list-style: none;
}

.orifilename {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<jsp:include page="../include/header.jsp" flush="false" />
	<div class="container">
		<div class="row">

			<form action="customerservice/qnainsert" method="post">
				<div class="form-group">
					<label for="qnaTitle">제목</label> <input name="qnaTitle"
						id="qnaTitle" class="form-control">
				</div>

				<div class="form-group">
					<label for="qnaContent">내용</label>

					<textarea class="form-control" id="qnaContent" rows="5"
						name="qnaContent"></textarea>
				</div>
			</form>
			
			<div class="form-group">

				<label>업로드할 파일을 드랍시키세요.</label>

				<div class="fileDrop"></div>

				<ul class="uploadedList clearfix">

				</ul>

			</div>

			<div class="form-group">

				<button class="btn btn-danger" type="submit" id="qnainsertbtn">등록</button>

				<button class="btn btn-danger" type="button" id="qnalistbtn">목록</button>

			</div>

		</div>

	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			
			$(".uploadedList").on("click",".deletefile", function(event){		//아이콘 클릭시 업로드된 파일 삭제
				event.preventDefault();
				var that = $(this);
				$.ajax({
					type : 'post',
					url : '/deletefile',
					dataType : 'text',
					data : {
						
						filename : that.attr("href")
						},
						success : function(result){
							that.parent("p").parent("li").remove();
						}


					});
				
				
				});

							$(".fileDrop").on("dragenter dragover",
									function(event) {

										event.preventDefault();

									});

							$(".fileDrop").on("drop",function(event) {								
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
														success : function(result) {																	
																/* var str = "<li><a href = '/displayfile?filename="+getImageLink(result)+"'>";

																if(checkImage(result)){

																	str += "<img src= '/displayfile?filename="+result+"'/>"

																}else{

																	str += "<img src = '/resources/show.png'/>"

																}

																

																

																str += getOriginalName(result);

																str += "</a><a class='deletefile' href='"+result+"'><span class='glyphicon glyphicon-trash'></span></a></li>"; */
																var str = '<li class="col-xs-4">';
																str += '<a href="/displayfile?filename='+ getImageLink(result)+ '">';																																				
																if (checkImage(result)) {
																	str += '<img src="/displayfile?filename='+ result+'"/>';			
																} else {
																	str += '<img src="/resources/show.png"/>';
																}
																str += '</a>';
																str += '<p class="orifilename">';
																str += '<a href="'+result+'" class="deletefile"><span class="glyphicon glyphicon-trash"></span></a>';
																str += getOriginalName(result);
																str += '</p>';
																str += '</li>';
																$(".uploadedList").append(str);																																					
															}

														});

											});

							$("#qnainsertbtn").click(function(event) {
								event.preventDefault();
								var str = '';
								
								$(".deletefile").each(function(index){
									str += "<input name='files["+index+"]' value='"+$(this).attr("href")+"' type='hidden'>";
									
									});
								
								
								

								
								$("form").append(str);
								$("form").submit();
							});
							

						});
	</script>



</body>
</html>
















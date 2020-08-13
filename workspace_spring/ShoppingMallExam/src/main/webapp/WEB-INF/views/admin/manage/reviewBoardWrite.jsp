<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Management</title>
<%@ include file="../include/head.jsp"%>
</head>
<body>
	<%@ include file="../include/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="../include/sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">REVIEW BOARD WRITE</h1>
				<div class="row">
					<form action="/review/insert" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label for="title">제목</label> <input name="title" id="title" class="form-control">
						</div>
						<div class="form-group">
							<label for="writer">작성자</label> <input name="writer" id="writer" class="form-control">
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" rows="10" name="content" id="content"></textarea>
						</div>
						<!-- <div class="form-group">
							<label for="file">첨부파일(업로드할 파일을 드랍시키세요)</label>
							<div class="panel panel-default" id="file">
								<div class="panel panel-body">
									<label>첨부파일 목록(삭제 버튼을 누르면 곧바로 삭제됩니다.)</label>
									<div class="fileDrop"></div>
									<ul class="uploadedList clearfix"></ul>
								</div>
							</div>
						</div> -->
					</form>
				</div>

				<div class="form-group">
					<button class="btn btn-info" id="insertBtn">등록</button>
					<button class="btn btn-primary" id="listBtn">목록</button>
				</div>

				<%@ include file="../include/footer.jsp"%>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$(".fileDrop").on("dragenter dragover",	function(event) {
				event.preventDefault();
		});
			
		$(".fileDrop").on("drop", function(event) {
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
					var str = '<li class="col-xs-4">';

					str += '<a href="/displayfile?filename='+ getImageLink(result)+ '">';
					if (checkImage(result)) {
						str += '<img src ="/displayfile?filename='+ result	+ '" />';
					} else {
						str += '<img src ="/resources/show.png"/>';
					}
					str += '</a>';

					str += '<p class="orifilename">';
					str += '<a class="deletefile" href="'+result+'"><span class="glyphicon glyphicon-trash"></span></a>';
					str += getOriginalName(result);
					str += '</p>';
					str += '</li>';

					$(".uploadedList").append(str);
				}
			});
		});

		$(".uploadedList").on("click", ".deletefile", function(event) {
			event.preventDefault();
			var that = $(this);

			$.ajax({
				type : 'post',
				url : '/deletefile',
				dataType : 'text',
				data : {
					filename : $(this).attr("href")
				},
				success : function(result) {
					alert(result);
					that.parent().parent("li").remove();
				}
			});
		});

		$("#insertBtn").click(function(event) {
			event.preventDefault();
			var str = '';

			$(".deletefile").each(function(index) {
				str += "<input name='files["+ index + "]' value='" + $(this).attr("href") + "' type='hidden'>";
			});

			$("form").append(str);
			$("form").submit();
		});

		$("#listBtn").click(function() {
			location.assign("/board/list");
		});
	</script>

</body>
</html>
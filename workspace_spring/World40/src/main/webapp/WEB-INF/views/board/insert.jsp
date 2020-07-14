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
<script src="/resources/js/uploadfn.js" type="text/javascript"></script>
<title>Insert title here</title>
<style type="text/css">
.fileDrop {
	width: 80%;
	height: 200px;
	border: 1px solid red;
	margin: auto;
}

.uploadedList {
	margin-top: 50px;
}
/* 앞의 점 없애기 */
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
	<!-- container면 좌우 여백, container-fluid는 여백 x -->
	<div class="container">
		<div class="row text-center">
			<h1>글쓰기</h1>
		</div>
		<div calss="row">
			<form action="/board/insert" method="POST">
				<div class="form-group">
					<label for="title">제목</label> <input name="title" id="title"
						class="form-control">
				</div>
				<div class="form-group">
					<label for="writer">작성자</label> <input name="writer" id="writer"
						class="form-control">
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
				<ul class="uploadedList clearfix">
				<!-- 단말기가 바뀔 때마다 다른 칸을 적용해라 -->
				<!-- <li class = "col-xs-2">
				<a href="#"><img src = "/resources/show.png"></a>
				<p class = "orifilename">aaaaaaaaaaaaa.txt<a><span class="glyphicon glyphicon-trash"></span></a></p>
				</li> -->
				</ul>
			</div>




			<div class="form-group">
				<button class="btn btn-danger" id="insertbtn">등록</button>
				<button class="btn btn-danger" id="listbtn">목록</button>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			//클릭했을 때
			$("#insertbtn").click(function(event) {
				event.preventDefault();

				var str = '';
				// .each 반복문을 돌린다.
				$(".deletefile").each(function(index){
					str += "<input name='files["+index+"]' value='"+$(this).attr("href")+"' type='hidden'>";

					});
				$("form").append(str);
				// submit되도록
				$("form").submit();
			});

			$(".uploadedList").on("click", ".deletefile", function(event){
				event.preventDefault();
				var that = $(this);

				$.ajax({

					type : 'post',
					url : '/deletefile',
					dataType : 'text',
					data : {
						filename : that.attr("href")
						},
						success : function(result) {
							// 부모 속성의 li를 없앤다.
							that.parent("p").parent("li").remove();
							}
					});
					
				});
			
			
			// 드래그해서 들어왔을 때
			$(".fileDrop").on("dragenter dragover", function(event) {
				// 기본 기능을 막아줌
				event.preventDefault();
			});

			// 해당 위치에 파일이 드랍되었을 때
			$(".fileDrop").on("drop", function(event) {
				event.preventDefault();

				// 드래그해서 가져온 파일들의 정보가 files에 담김
				var files = event.originalEvent.dataTransfer.files;

				// 파일들 중 맨 처음에 있는 파일만 가져온다.
				var file = files[0];

				// form 태그를 만들어준 뒤, append로 추가
				// for문을 사용하면 여러개의 파일을 업로드 할 수 있음
				var formData = new FormData();
				formData.append("file", file);

				$.ajax({
					type : 'post',
					url : '/uploadajax',
					dataType : 'text',
					data : formData,
					// 2개의 속성이 더 들어가야 한다.
					processData : false,
					contentType : false,
					success : function(result) {
						// 업로드가 되면 1줄씩 그 내용이 나온다.
						// 원본파일이 보일 수 있도록 한다.
						// /가 있다는 것은 절대좌표
				/* 		var str = "<li><a href = '/displayfile?filename="+getImageLink(result)+"'>";

						if (checkImage(result)) {
							// 파일명이 아니라 데이터 그 자체를 값으로 준다.
							str += "<img src = '/displayfile?filename=" + result + "'/>"
						} else {
							str += "<img src = 'resources/show.png'/>"
						}

						str += getOriginalName(result);
						// ajax로 구현할 것이므로 온전한 주소가 들어갈 필요는 없다.
						str += "</a><a class = 'deletefile' href='"+result+"'><span class='glyphicon glyphicon-trash'></span></a></li>";
 */

 					var str = '<li class = "col-xs-4">';
					str += '<a href="/displayfile?filename='+ getImageLink(result) +'">';
					if(checkImage(result)) {
							str += '<img src ="/displayfile?filename='+result+'" />'; //썸네일의 결과가 들어감
					}else {
							str += '<img src = "/resources/show.png"/>';
							}
					
					str += '</a>';
					str += '<p class = "orifilename">';
					str += getOriginalName(result);
					str += '<a href="'+result+'" class = "deletefile"><span class="glyphicon glyphicon-trash"></span></a>';
					str += '</p>';
 					str += '</li>';

					$(".uploadedList").append(str);

					}
				});
			});	
		});

	</script>
</body>
</html>
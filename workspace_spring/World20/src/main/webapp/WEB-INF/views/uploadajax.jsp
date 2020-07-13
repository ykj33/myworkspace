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
.fileDrop {
	width: 80%;
	height: 200px;
	border: 1px dotted red;
}
</style>
</head>
<body>
	<div class="fileDrop"></div>
	<div class="uploadedList"></div>

	<script type="text/javascript">
		$(document).ready(function() {

			$(".uploadedList").on("click",".deletefile", function(event) {
				// 방지하지 않으면 그대로 href의 값이 넘어가버린다.
				event.preventDefault();
				// 지금 클릭되고 있는 것을 that이라는 변수로 받겠다. 통신이 끝나기 전에 미리 선언
				var that = $(this);
				
				$.ajax({
					type : 'post',
					url : '/deletefile',
					dataType : 'text',
					data : {
						// 내가 누른 this의 href 안의 result값을 가져온다.
						filename : $(this).attr("href")
						},
						success : function(result) {
							alert(result);
							// 상위의 div를 제거한다.
							that.parent("div").remove();
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
						var str = "<div><a href = '/displayfile?filename="+getImageLink(result)+"'>";

						if (checkImage(result)) {
							// 파일명이 아니라 데이터 그 자체를 값으로 준다.
							str += "<img src = '/displayfile?filename=" + result + "'/>"
						} else {
							str += "<img src = 'resources/show.png'/>"
						}

						str += getOriginalName(result);
						// ajax로 구현할 것이므로 온전한 주소가 들어갈 필요는 없다.
						str += "</a><a class = 'deletefile' href='"+result+"'><span class='glyphicon glyphicon-trash'></span></a></div>";

						$(".uploadedList").append(str);

					}
				});
			});
		});

		
		function getOriginalName(filename) {
			if (checkImage(filename)) {
				var idx = filename.indexOf("_"); // 첫 번째 언더바 찾기

				idx = filename.indexOf("_", idx + 1); // 첫 번째 찾은 언더바 다음부터 언더바 찾기
				return filename.substring(idx + 1);
			} else {
				var idx = filename.indexOf("_");
				return filename.substring(idx + 1); // original name
			}
		}

		function checkImage(filename) {
			var idx = filename.lastIndexOf(".");
			var format = filename.substring(idx + 1).toUpperCase();
			if (format == 'PNG' || format == 'JPG' || format == 'JPEG'
					|| format == 'GIF') {
				return true;
			} else {
				return false;
			}
		}

		

		function getImageLink(result) {
			if (checkImage(result)) {
				// 이미지 파일일 경우 s_만 제거
				// 선생님의 방법
				return result.substring(0, 12) + result.substring(14);
				// 내 방법
				// return result.replace("s_", "");
			} else {

				// 아닐 경우 그냥 반환
				return result;
			}
		}
	</script>
</body>
</html>
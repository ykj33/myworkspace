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
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<h1>글 자세히 보기</h1>
		</div>
		<div class="row">
			<div class="form-group">
				<label for="title">제목</label> <input readonly value="${vo.title }"
					class="from-control">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label> <input readonly
					value="${vo.writer }" class="from-control">
			</div>
			<div class="form-group">
				<label for="content">제목</label>
				<textarea rows="5" class="form-control">${vo.content }</textarea>
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
		<!--  class = row -->
		<!-- 댓글 -->
		<div class="row">
			<!-- class = collapse를 넣어서 나왔다 숨겼다를 할 수 있다. -->
			<div id="myCollapse" class="collapse">
				<div class="form-group">
					<label for="replyer">작성자</label> <input class="form-control"
						id="replyer">
				</div>

				<div class="form-group">
					<label for="replytext">내용</label> <input class="form-control"
						id="replytext">
				</div>
				<div class="form-group">
					<button id="replyInsertBtn" class="btn btn-primary">댓글 등록</button>
				</div>
			</div>
		</div>
	</div>
	<!-- class=container -->
	<script type="text/javascript">

		/* 전역변수로 선언되어 쓸 수 있음 */
		var bno = $
		{
			vo.bno
		};
		$(document).ready(function() {
			$("#replyInsertBtn").click(function() {
				var replyer = $("#replyer").val();
				var replytext = $("#replytext").val();
				console.log(replyer);
				console.log(replytext);
			});

			$("#reply_form").click(function() {
				$("#myCollapse").collapse("toggle");
			});
			$("#update").click(function() {
				location.assign("/board/update/${vo.bno}");
			});
			$("#delete").click(function() {
				location.assign("/board/delete/${vo.bno}");
			});
			$("#list").click(function() {
				location.assign("/board/list");
			});

		});
	</script>
</body>
</html>
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
			<!-- class = collapse -->
		</div>
		<!-- class = row -->

		<div id="replies" class="row">
			<!-- 어차피 덮어씌워지는 코드일 뿐 -->
			<div class="panel panel-success">
				<div class="panel-heading">
					<span>rno : 3</span>, <span>작성자 : 홍길동</span> <span
						class="pull-right">2020년07월07일.....</span>
				</div>
				<div class="panel-body">
					<p>댓글 내용입니다.</p>
					<button data-name="홍길동" class="btn btn-warning btn-xs replymodify">수정</button>
					<button class="btn btn-danger btn-xs replydelete">삭제</button>
				</div>
			</div>
		</div>
		<!-- class = row -->

		<div class="row">
			<!-- static 값을 주면 정상적인 방식을 통해서만 모달을 닫을 수 있다. -->
			<div data-backdrop="static" id="myModal" class="modal fade"
				tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-rno">rno 데이터</h4>
						</div>
						<div class="modal-body">
							<p class="modal-replyer">댓글 작성자</p>
							<input value="댓글 내용입니다." class="form-control modal-replytext" />
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-warning modal-update-btn"
								data-dismiss="modal">댓글 수정</button>

						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>
	</div>
	<!-- class=container -->
	<script type="text/javascript">
		/* 전역변수로 선언되어 쓸 수 있음 */
		var bno = ${vo.bno};
		getList(bno);
		$(document).ready(function() {

			// 동적으로 만들어지는 조상태그가 아닌 정적 조상태그가 중요하다.
			$("#replies").on("click", ".replymodify", function() {
				// 선택한 버튼의 속성을 가져온다.
				var rno = $(this).attr("data-rno");
				var replyer = $(this).attr("data-name");
				//prev를 통해 조상의 태그 가져옴
				var replytext = $(this).prev().text();

				$(".modal-rno").text(rno);
				$(".modal-replyer").text(replyer);
				$(".modal-replytext").val(replytext);
				$("#myModal").modal("show");
			});

			// 버튼을 눌렀을 때 업데이트
			$(".modal-update-btn").click(function() {
				var rno = $(".modal-rno").text();
				var replytext = $(".modal-replytext").val();
				$.ajax({
					// 수정할 때는 put
					type : 'put',
					url : "/replies/" + rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Ovverride" : "PUT"
					},
					dataType : 'text',
					data : JSON.stringify({
						replytext : replytext
					}),
					success : function(result) {
						if (result === "success") {
							// 성공시 리스트 새로 불러오기
							getList(bno);
						}
					}

				});
			});
			$("#replies").on("click", ".replydelete", function() {
				var rno = $(this).attr("data-rno");
				$.ajax({
					type : 'delete',
					url : "/replies",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Ovverride" : "DELETE"
					},
					dataType : 'text',
					data : JSON.stringify({
						rno : rno
					}),
					success : function(result) {

						getList(bno);
					}
				});
			});
			// 댓글 작성
			$("#replyInsertBtn").click(function() {

				var replyer = $("#replyer").val();
				var replytext = $("#replytext").val();
				console.log(replyer);
				console.log(replytext);

				$.ajax({
					type : 'post',
					// /가 있다는건 앞에 board가 없다.
					url : '/replies',
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					dataType : "text",
					data : JSON.stringify({
						/* 변수명 : 변수값으로 설정 */
						bno : bno,
						replyer : replyer,
						replytext : replytext
					}),
					success : function(result) {
						// val() 안에 아무것도 넣지 않으면 공백으로 값이 치환된다.
						// 성공 시 다시 값을 공백으로 만든다.
						$("#replyer").val("");
						$("#replytext").val("");
						// 댓글 추가 이후에 다시 리스트 가져오기
						getList(bno);
					},
					error : function(request, status, error) {
						console.log(error);
					}
				});
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

		function getList(bno) {
			/* "" 가 아니라 ''로 붙여넣기 */
			// str의 코드를 계속 붙여서 출력하는 방식
			var str = '';
			$
					.getJSON(
							"/replies/all/" + bno,
							function(data) {
								for (var i = 0; i < data.length; i++) {
									// rno값을 넘겨주어야 하는데, 이를 위해 사용자 정의 속성을 사용하여 임의로 값을 넣어준다.
									str += '<div class="panel panel-success"><div class="panel-heading"><span>rno : ' + data[i]["rno"]+ '</span>,<span>작성자 : '+ data[i]["replyer"] + '</span> <span class="pull-right">' + data[i]["updatedate"] + '</span></div><div class="panel-body"><p>' + data[i]["replytext"]+ '</p><button data-rno="'+data[i]["rno"]+'" data-name="'+data[i]["replyer"]+'"class="btn btn-warning btn-xs replymodify">수정</button><button data-rno="'+data[i]["rno"]+'" class="btn btn-danger btn-xs replydelete">삭제</button></div></div>';
								}
								// 해당 아이디의 태그의 html에 덮어 씌운다.
								$("#replies").html(str);
							});
		}
	</script>
</body>
</html>
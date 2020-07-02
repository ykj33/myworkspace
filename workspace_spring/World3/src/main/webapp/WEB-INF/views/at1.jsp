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
	<button>at1</button>
	<p></p>
	<script type="text/javascript">
		// jquery기본코드
		$(document).ready(
				function() {
					$("button").click(
							function() {
								$.ajax({
									// 데이터 전송방식
									type : 'post',
									// 목적지
									url : '/at1',
									// 넘겨주는 데이터 타입
									dataType : 'text',
									// 넘겨주는 데이터
									// 데이터 이름과 값을 다 '',""로 묶어준다. 숫자는 제외
									data : {
										'msg' : "hello"
									},
									// 통신 성공 시, 실패 시 설정
									success : function(result) {
										$("p").text(result);
										// 이렇게도 사용한다.
										/* var msg = $("p").text(); */
									},
									// error일 때는 파라미터로 request, status, error 3가지를 꼭 넣어주어야 한다.
									error : function(request, status, error) {
										console.log("code" + request.status
												+ "\n" + "msg : "
												+ request.responseText + "\n"
												+ "error : " + error);
									},
									// 성공, 실패에 상관없이 출력
									complete : function() {
										alert("ok");
									}
								});
							});
				});
	</script>
</body>
</html>
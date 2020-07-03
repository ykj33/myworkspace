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
	<button>rt1 버튼</button>
	<script type="text/javascript">
		$(document).ready(function() {
			$("body").on("click", "button", function() {
				var test1 = "hello";
				$.ajax({
					type : 'post',
					url : 'rt1',
					// RestController를 이용하기 위해선 headers필요
					headers : {
						'Content-Type' : 'application/json',
						// type이 post면 post
						'X-HTTP-Method-Override' : 'POST',
						
						},
					dataType : 'text',
					data : JSON.stringify({
						// 변수명 : 실제 데이터
						test1 : test1
						}),
						success(result) {
						console.log(result);
						},
						error : function(request, status, error) {
								console.log(error);
							}
				});
			});
		});
	</script>
</body>
</html>
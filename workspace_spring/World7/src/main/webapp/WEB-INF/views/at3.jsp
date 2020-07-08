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
	<button id="btn">at3 test</button>
	<p class="name"></p>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#btn").click(function() {
				$.ajax({
					type : 'post',
					url : 'at3',
					dataType : 'text',
					data : {
						// data를 json형태로 넣었다.
						// 속성명이 ''로 감싸져 있으면 거의 json
						'id' : 'm004',
						'name' : 'lee',
						'age' : 33
					},
					success : function(result) {
						console.log(result);
						// json형태로 된 데이터를 parse하면 하나의 객체를 만들어준다.
						var obj = JSON.parse(result);
						console.log(obj.id);
						console.log(obj.name);
						console.log(obj.age);
						// 데이터를 받아서 해당 태그에 텍스트로 넣어준다.
						$(".name").text(obj.name);
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
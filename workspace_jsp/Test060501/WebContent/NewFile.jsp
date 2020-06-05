<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
	<form action="insert.do" method="post">
		ID : <input name="id" id="id">
		<button>id 중복 체크</button>
		<p></p>
		<br> <br> <input type="submit" value="회원 가입">

	</form>

	<script type="text/javascript">
		$(document).ready(function() {
			$("button").click(function(event) {
				// form태그에 있는 action으로 넘어가는 것을 막는다.
				event.preventDefault();
				//id가 id인 input태그의 정보를 가져와야 함
				var id = $("#id").val();
				// var로 뽑은 값, 통신을 거쳐 servlet으로부터 받는 타입, String이 아니라 text, 성공시 할 일 순으로.
				// ajax코드 안에는 주석을 달지 말자. 에러 날 수 있음.
				$.ajax({
					type : "get",
					url : "idcheck",
					data : {
						id : id
					},
					dataType : "text",
					success : function(result) {
						$("p").text(result);

					}
				});
			});
		});
	</script>
</body>
</html>
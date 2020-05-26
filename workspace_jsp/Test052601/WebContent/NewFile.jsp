<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ms2" method="post">
		ID : <input name="id"><br> PW : <input name="pw"><br>
		<input type="submit" value="로그인">
	</form>
	<hr>
	<form action="ms2" method="get">
		<!-- input name에 해당 파라미터의 이름을 넣어야 값이 들어간다 -->
		name : <input name="name"><br> age : <input name="age"><br>
		<input type="submit">
	</form>
</body>
</html>
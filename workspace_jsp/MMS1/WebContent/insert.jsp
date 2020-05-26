<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입 화면</h1>
<!-- URL 패턴값이 insert이므로 그냥 insert라고 쓴다 -->
<form action = "insert" method = "post">
아이디 : <input name = "id"><br>
이름 : <input name = "name"><br>
나이 : <input name = "age"><br>
<input type = "submit" value = "회원 가입">
</form>
</body>
</html>
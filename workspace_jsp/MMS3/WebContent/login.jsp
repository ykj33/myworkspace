<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session = "false"%> <!-- session = "false" 추가 필요 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="login.bo" method = "post">
ID : <input name = "id">
<br>Password : <input name = "password" type = "password">
<br><input type = "submit" value = "로그인">
</form>
</body>
</html>
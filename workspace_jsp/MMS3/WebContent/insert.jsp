<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="insert.bo" method="post">
		<!-- 중복체크가 필요하다 -->
		ID : <input name="id"> 
		<br>Name : <input name="name">
		<br>Age : <input type=number name="age"> 
		<br>Password : <input type=password name="password">
		<br><input type = "submit" value = "회원가입">
	</form>

</body>
</html>
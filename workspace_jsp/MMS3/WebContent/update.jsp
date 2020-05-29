<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보수정</h1>
	<form action="update.bo" method="post"> 
	ID : <input name="id" readonly value = ${dto.id }> <br>
	Name : <input name="name" value = ${dto.name }> <br>
	Age : <input type="number" name="age" value = ${dto.age }><br>
	Pw : <input name = "pw" type = "password" required placeholder ="꼭 입력해주세요."><br>
	<input type="submit" value="수정">
	</form>
</body>
</html>
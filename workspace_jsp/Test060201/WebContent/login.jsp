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
</head>
<body>
	<form action="NewFile8.jsp" method="post">
		<!-- name 값을 loginBean의 property값과 같아야 한다. -->
		ID : <input name="id"><br>
		PW : <input name="pw"><br>
		<input type = "submit" value = "로그인">

	</form>
</body>
</html>
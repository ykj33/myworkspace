<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ${3+4} -->
	<!-- ${login.id}  -->
	<!-- ${} --> 에러 발생
	<%-- ${} --%> 에러가 발생하지 않는다.

	<!-- <h1>html</h1> -->
	//
	<h1>/*java1*/</h1>
	<%
		int a = 0;
		/*out.print(a);*/
	%>

	<%--
	<h1>jsp</h1>
	--%>
</body>
</html>
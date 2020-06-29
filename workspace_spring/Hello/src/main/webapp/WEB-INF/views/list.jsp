<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		for (int i = 0; i < 11; i++) {
		out.print("Good moring" + i);
	%>
	<br>
	<%
		}
	%>
</body>
</html>
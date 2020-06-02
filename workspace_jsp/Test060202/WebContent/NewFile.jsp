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
	<h1>Expression Language(표현 언어)</h1>
	산술연산 가능<br>
	${111 }<br>
	${"hello" }<br>
	${1+2 }<br> 
	${1-2 }<br>
	${1*2 }<br> 
	${1/2}<br>
	${1%2}
	<hr>
	비교연산 가능<br>
	${1>2 }<br>
	${1 >= 2 }<br>
	${1 < 2 }<br>
	${1 <= 2 }<br>
	${1 == 2 }<br>
	${1 != 2 }
	<hr>
	논리연산 가능<br>
	${true && true }<br>
	${(3>4) && (5<6)}<br>
	${true || false }<br>
	<hr>
	삼항 연산자 가능<br>
	${3 > 4 ? 100 : -5 }<br>
	<%
	request.setAttribute("a", 11);
	%>
	<!-- '와 "가 같이 있으면 안되므로 섞어서 해주어야 한다. -->
	<a href='${a>3?"http://www.naver.com" : "http://www.google.com" }'>hello</a>
</body>
</html>
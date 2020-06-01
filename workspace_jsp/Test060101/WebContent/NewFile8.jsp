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
	<h1>Expression Tag</h1>
	<%
		out.print("hello");
	%>
	<%="hello"%>
	<%
		out.print("<h1>Hello</h1>");
	%>
	<h1><%="Hello"%></h1>
	<%
		request.setAttribute("name", "kim");
	%>
	${name}
	<br>

	<!-- expression 태그가 더 편한 경우 -->
	<%
		for (int i = 0; i < 10; i++) {
	%>
	<%=i%><br>
	<%
		}
	%>

	<!-- 이러한 상황에서는 EL을 사용할 수 있다. -->
	<%
		for (int i = 0; i < 10; i++) {
			pageContext.setAttribute("i", i);
	%>
	${i}
	<br>
	<%
		}
	%>
</body>
</html>
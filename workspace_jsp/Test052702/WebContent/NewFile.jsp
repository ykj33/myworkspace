<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String hello = (String) application.getAttribute("hello");
		List<StringBuffer> list = (List<StringBuffer>) application.getAttribute("list");
		// 반드시 int가 아닌 Integer로 받아야 한다.
		Integer count = (Integer) application.getAttribute("count");

		// out은 내장객체이므로 객체 선언없이 사용할 수 있다.
		out.println(hello);
		for (int i = 0; i < list.size(); i++) {
			out.println(list.get(i));
		}
		out.println(count);
	%>

</body>
</html>
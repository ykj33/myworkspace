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
	<!-- pageContext에 바인딩하여 출력 X -->
	${p }<br> 
	<!-- 나머지는 출력, 포워딩이 dispatcher이기 때문 -->
	${r }<br> 
	${s }<br> 
	${a }<br>
	
	<%
	response.sendRedirect("NewFile4.jsp");
	%>
</body>
</html>
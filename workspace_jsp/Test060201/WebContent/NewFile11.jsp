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
	<%!int count = 0;%>
	<%
		//frontController에 넣어서 어디에 가더라도 방문자수가 증가될 수 있도록 한다.
		count++;
		application.setAttribute("count", count);
	%>
	<label>방문자수 : </label>${count }
</body>
</html>
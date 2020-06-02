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
	<%
		String msg = "good";
		pageContext.setAttribute("p", "pageContext");
		request.setAttribute("r", "request");
		session.setAttribute("s", "session");
		application.setAttribute("a", "application");
	%>

	<!-- 바인딩 된 데이터가 아닌 경우 EL로 출력되지 않는다. -->
	${msg }
	<br> ${p }
	<br> ${r }
	<br> ${s }
	<br> ${a }
	<br>
	
	<jsp:forward page="NewFile3.jsp" />

</body>
</html>
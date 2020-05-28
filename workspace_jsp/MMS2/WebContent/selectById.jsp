<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 자세히보기</h1>
	<%
		MemberDTO dto = (MemberDTO) request.getAttribute("dto");
	%>
	<%-- <%=  %> 안에 적으면 expression tag라고 하여 view에 출력해줌 --%>
	ID : <%=dto.getId()%><br> 
	Name : <%=dto.getName()%><br> 
	Age : <%=dto.getAge()%><br>
	<!-- update를 누구를 할 것인가를 특정해줌 -->
	<a href="updateui.do?id=<%= dto.getId()%>">수정</a>	| <a href="delete.do?id=${dto.id}">삭제</a> | <a href = "select.do">목록</a>
</body>
</html>
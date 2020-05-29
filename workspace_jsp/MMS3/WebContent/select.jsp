<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${empty login ? 'loginui.bo' : 'logout.bo' }">${empty login ? '로그인' : '로그아웃' }<br></a>
	<a href="insertui.bo">회원가입</a>
	<h1>회원 목록</h1>
	<!-- forEach문으로 리스트 출력 -->
	<c:forEach items="${list}" var="dto">
		<a href="selectById.bo?id=${dto.id}">${dto.id} : ${dto.name}</a>
		<br>
	</c:forEach>
	<br>

</body>
</html>
<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
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

	<!-- EL과 삼항연산자를 이용하여 로그인버튼 구현 가능 -->
	<a href=${empty login  ? 'loginui.do' : 'logout.do'}>${empty login  ? '로그인' : '로그아웃'}</a>
	<br>


	<a href="insertui.do">회원등록</a>
	<br>
	<br>


	<!-- EL로 해당 덩어리를 호출하고 var의 변수에 담는 향상된 for문 -->
	<c:forEach items="${list}" var="dto">
		<a href="selectById.do?id=${dto.id}">${dto.id}:${dto.name}</a>
		<br>

	</c:forEach>


</body>
</html>
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
	<h1>게시글 자세히보기</h1>
	번호 = ${dto.num}
	<br> 제목 = ${dto.title }
	<br> 작성자 = ${dto.writer }
	<br> 내용 = ${dto.content }
	<br> 작성일 = ${dto.writeday }
	<br> 조회수 = ${dto.readcnt }
	<br>
	<br>

	<a href="updateui.do?num=${dto.num}">수정</a> |
	<a href="delete.do?num=${dto.num }">삭제</a> |
	<a href="replyui.do?num=${dto.num }">답글</a> |
	<a href="list.do">목록</a>
</body>
</html>
<%@page import="kr.co.domain.BoardDTO"%>
<%@page import="java.util.List"%>
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
	<h1>게시글 목록</h1>
	<a href="insertui.do">글쓰기</a>

	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>repRoot</th>
				<th>repStep</th>
				<th>repIndent</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>

					<!-- 0부터 시작하면 원글도 들여쓰기가 되므로 1부터 시작한다. -->
					<td width="300px"><c:forEach begin="1" end="${dto.repIndent }">
					&nbsp;	&nbsp;
					</c:forEach> <a href="read.do?num=${dto.num }">${dto.title }</a></td>

					<td>${dto.writer }</td>
					<td>${dto.writeday }</td>
					<td>${dto.readcnt }</td>
					<td>${dto.repRoot }</td>
					<td>${dto.repStep }</td>
					<td>${dto.repIndent }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
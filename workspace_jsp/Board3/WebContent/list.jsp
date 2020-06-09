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
				<!-- <th>repRoot</th>
				<th>repStep</th>
				<th>repIndent</th> -->
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
					<%-- <td>${dto.repRoot }</td>
					<td>${dto.repStep }</td>
					<td>${dto.repIndent }</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 왼쪽 화살표 -->
	<!-- 삼항 연산자로 -값을 가지지 않게 할 수 있다. -->
	<a href="list.do?curPage=${(to.curPage-1) >1?(to.curPage-1):1}">&laquo;
	</a>&nbsp;&nbsp;
	<!-- 페이지 번호 띄우고 링크걸기 -->
	<c:forEach begin="${to.beginPageNum }" end="${to.stopPageNum }"
		var="idx">

		<c:if test="${to.curPage == idx }">
			<!-- 해당 페이지를 보고 있을 시 숫자 크기 변경 -->
			<a style="font-size: 50px;" href="list.do?curPage=${idx}">${idx}</a> &nbsp;&nbsp;
		</c:if>
		<c:if test="${to.curPage != idx }">
			<!-- 숫자 찍고 2칸 띄우기 -->
			<a href="list.do?curPage=${idx}">${idx}</a> &nbsp;&nbsp;
		</c:if>


	</c:forEach>
	<!-- 오른쪽 화살표 -->
	<a	href="list.do?curPage=${(to.curPage+1) < to.totalPage ? (to.curPage+1) : to.totalPage }">&raquo;</a>&nbsp;&nbsp;

</body>
</html>
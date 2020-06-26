<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="UTF-8">

<title>IT 제품 리뷰</title>
<!-- 파비콘 적용 -->
<link rel="shorcut icon" href="favicon.ico" type="image/x-icon">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	display: flex;
	flex-direction: column;
	-ms-flex-align: center;
	align-items: center;
	background-color: #f5f5f5;
}

.container-fluid {
	max-width: none;
}

.float-right, .container-fluid footer {
	max-width: none;
	width: 100%;
}

.back {
	float: right;
	margin-bottom: 50px;
}

.manager, .customer {
	width: 50%;
	margin: 0px;
	max-width: inherit;
}

.manager {
	float: left;
	padding-right: 20px;
}

.customer {
	float: right;
	padding-left: 20px;
}

thead {
	text-align: center;
}

th {
	border: 3px solid black;
	border-top: 3px solid black;
	padding: 8px;
	max-width: inherit;
}

th.id, th.name {
	width: 35%;
}

th.prpt, th.del {
	width: 15%;
}

td {
	border-bottom: 3px solid silver;
	border-left: 1px solid silver;
	border-right: 1px solid silver;
	text-align: center;
}
</style>
<c:if test="${!admin }">
	<style>
.customer {
	width: 100%;
}
</style>
</c:if>
</head>
<body>

	<div class="container-fluid" style="padding: 20px 320px 0px 320px;">
		<jsp:include page="header.jsp" />
		<h1 align="center">최신글</h1>
		<br> <br>
		<div class="manager">

			<h3>
				<a href="reviewlist.do">리뷰게시판</a>
			</h3>
			<table class="table">
				<thead>
					<tr class="table-info">
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>카테고리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="dto" begin="0" end="10">
						<tr class="thead-light">
							<td style="vertical-align: middle">${dto.num }</td>
							<td><a href="reviewread.do?num=${dto.num }">${dto.title }</a></td>
							<td><a href="memberselectById.do?id=${dto.id }">${dto.id }</a></td>
							<td>${dto.category }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div class="manager">

			<h3>
				<a href="freelist.do">자유게시판</a>
			</h3>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>번호</th>
						<th>제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${freelist }" var="fdto" begin="0" end="10">
						<tr class="thead-light">
							<td style="vertical-align: middle">${fdto.fnum }</td>
							<td><c:forEach begin="1" end="${fdto.repIndent }">
					ㄴ&nbsp;	&nbsp;
					</c:forEach> <a href="freeread.do?fnum=${fdto.fnum }">${fdto.ftitle }</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

	</div>

	<div class="container-fluid footer"
		style="padding: 20px 320px 0px 320px;">
		<jsp:include page="footer.jsp" />
	</div>

</body>


</html>
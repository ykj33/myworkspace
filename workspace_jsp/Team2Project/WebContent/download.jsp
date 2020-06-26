<%@ page language="java" contentType="application/vnd.ms-excel; charset=euc-kr"%>
<%
    response.setHeader("Content-Description", "JSP Generated Data");  
    response.setHeader("Content-Disposition", "attachment;filename=ServieRequestList.xls");

%>

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

	<div class="container-fluid" style="padding: 20px 320px 0px 320px;">
		<h1 align="center">회원 관리</h1>
		<br> <br>
		<div class="manager">
		<h3>manager</h3>
				<h3>매니저</h3>
				<table class="table">
					<thead>
						<tr class="table-info">
							<th class="id">아이디</th>
							<th class="name">이름</th>
							<th class="prpt">권한</th>
							<th class="del">탈퇴</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${man }" var="list">
							<tr class="thead-light">	
								<td style="vertical-align: middle">${list.id }</td>
								<td style="vertical-align: middle">${list.name }</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>

		</div>

		<div class="customer">
			<h3>회원</h3>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th class="id">아이디</th>
						<th class="name">이름</th>
						<c:if test="${admin}">
							<th class="prpt">권한</th>
						</c:if>
						<th class="del">탈퇴</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cus}" var="list">
						<tr class="thead-light">
							<td style="vertical-align: middle">${list.id}</td>
							<td style="vertical-align: middle">${list.name }</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br> <br>
		</div>

	</div>
	
</body>
</html>
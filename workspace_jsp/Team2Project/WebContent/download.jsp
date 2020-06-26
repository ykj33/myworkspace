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
		<h1 align="center">ȸ�� ����</h1>
		<br> <br>
		<div class="manager">
		<h3>manager</h3>
				<h3>�Ŵ���</h3>
				<table class="table">
					<thead>
						<tr class="table-info">
							<th class="id">���̵�</th>
							<th class="name">�̸�</th>
							<th class="prpt">����</th>
							<th class="del">Ż��</th>
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
			<h3>ȸ��</h3>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th class="id">���̵�</th>
						<th class="name">�̸�</th>
						<c:if test="${admin}">
							<th class="prpt">����</th>
						</c:if>
						<th class="del">Ż��</th>
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
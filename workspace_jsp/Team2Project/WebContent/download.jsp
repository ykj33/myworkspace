<%@page import="java.awt.print.Printable"%>
<%@page import="member.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java"
	contentType="application/vnd.ms-excel; name='excel', text/html; charset=euc-kr"
	pageEncoding="EUC-KR"%>





<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<%
/* �ѱ��� ������ �ʰ� �ϱ� ���� html �������� �ε� �� ������ charset�� �������ش�. */
	out.print("<meta http-equiv=\"Content-Type\" content=\"application/vnd.ms-excel; charset=euc-kr\">");
%>
<title>Insert title here</title>
</head>

<%
/* jsp ������ ä�� �ٿ�ε� �ϱ� ���� ��� ���� */
response.setHeader("Content-type", "application/vnd.ms-excel; charset=euc-kr");

response.setHeader("Content-Disposition", "attachment;filename= download.xls;");

response.setHeader("Content-Description", "JSP Generated Data");
%>



<body>

	<div class="container-fluid" style="padding: 20px 320px 0px 320px;">
		<h1 align="center">ȸ�� ����</h1>
		<br> <br>

		<h3>ȸ�����</h3>
		<table class="table">
			<thead>
				<tr>
					<th>���̵�</th>
					<th>�̸�</th>
					<th>����</th>

				</tr>
			</thead>
			<tbody>
				<%
				/* EL�� �����͸� �ѷ��� �� ���� ������, ���尴ü out�� �̿��Ͽ� �����͸� �ѷ��ش�. */
					List<MemberDTO> list = (List<MemberDTO>) request.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td>
						<%
							out.print(list.get(i).getId());
						%>
					</td>
					<td>
						<%
							out.print(list.get(i).getName());
						%>
					</td>
					<td>
						<%
							out.print(list.get(i).getProperty());

						}
						%>
					</td>
				</tr>
</body>
</html>
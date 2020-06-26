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
/* 한글이 깨지지 않게 하기 위해 html 페이지가 로딩 될 때마다 charset을 설정해준다. */
	out.print("<meta http-equiv=\"Content-Type\" content=\"application/vnd.ms-excel; charset=euc-kr\">");
%>
<title>Insert title here</title>
</head>

<%
/* jsp 페이지 채로 다운로드 하기 위한 헤더 설정 */
response.setHeader("Content-type", "application/vnd.ms-excel; charset=euc-kr");

response.setHeader("Content-Disposition", "attachment;filename= download.xls;");

response.setHeader("Content-Description", "JSP Generated Data");
%>



<body>

	<div class="container-fluid" style="padding: 20px 320px 0px 320px;">
		<h1 align="center">회원 관리</h1>
		<br> <br>

		<h3>회원목록</h3>
		<table class="table">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>권한</th>

				</tr>
			</thead>
			<tbody>
				<%
				/* EL로 데이터를 뿌려줄 수 없기 때문에, 내장객체 out을 이용하여 데이터를 뿌려준다. */
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
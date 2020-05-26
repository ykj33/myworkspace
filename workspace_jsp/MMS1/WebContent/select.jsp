<%@page import="kr.co.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="insertui">회원 등록</a>

	<h1>모든 회원 정보 목록</h1>
	<%
		Object olist = request.getAttribute("list");
		List<MemberDTO> list = null;
		if (olist != null) {
			// 강제 형변환
			list = (List<MemberDTO>) olist;
			for (int i = 0; i < list.size(); i++) {
				MemberDTO dto = list.get(i);
				out.print(dto);
				out.print("<br>");
			}
		}
	%>
</body>
</html>

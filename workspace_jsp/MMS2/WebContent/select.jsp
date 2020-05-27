<%@page import="kr.co.domain.MemberDTO"%>
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
	<%
		// 바인딩 된 데이터 획득
		List<MemberDTO> list = (List<MemberDTO>) request.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			// id를 눌렀을 때 상세정보를 보기 위한 버튼
			out.print("<a href='selectById.do?id=" + dto.getId() + "'>");
			out.print(dto.getId());
			out.print(":");
			out.print(dto.getName());
			out.print("</a>");
			out.print("<br>");
		}
	%>

</body>
</html>
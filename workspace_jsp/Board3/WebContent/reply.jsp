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
<h1>답글 작성</h1>
	<form action="reply.do" method="post">
		<!-- 파라미터로 값을 받았으니 param 내장 객체를 이용한다. -->
		<input type ="hidden" name = "num" value="${param.num }"><br>
		작성자 : <input name="writer"><br> 
	    제목 : <input name="title"><br>
		내용 : <textarea rows="5" name = "content"></textarea><br>
		<input type="submit" value="답글작성">
	</form>
</body>
</html>
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

	파일명 : ${fileName }
	<br> 원파일명 : ${orgFileName }
	<br>
	<!-- 다운로드하려는 파일의 이름을 값으로 넘겨준다. -->
	<a href="download?fileName=${fileName }">${orgFileName } 파일 다운로드</a>

</body>
</html>
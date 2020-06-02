<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:useBean class="com.naver.LoginBean" id="login" />
<!-- 동적으로 값을 줄 때는 value가 아닌 param으로 name 값을 받는다. -->
<jsp:setProperty property="id" name="login" param="idTest" />
<jsp:setProperty property="pw" name="login" param="pwTest" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>${login.id } : ${login.pw }
</body>
</html>

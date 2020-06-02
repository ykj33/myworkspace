<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:useBean id="login" class="com.naver.LoginBean" />
<!-- input값의 name과 javaBean의 필드값의 이름이 같다면 *로 일일히 지정해주지 않아도 받을 수 있다. -->
<jsp:setProperty property="*" name="login" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>${login.id } : ${login.pw }
</body>
</html>
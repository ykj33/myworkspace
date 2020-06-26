<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>IT 제품 리뷰</title>
<!-- 파비콘 적용 -->
<link rel="shorcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
<div style="padding: 20px 320px 0px 320px;">
		<jsp:include page="header.jsp" />
		<h1>글쓰기</h1>

		<form action="freeupdate.do?fnum=${list.fnum }" method="post" enctype="multipart/form-data">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="id">작성자</label> <input name="id" type="text"
						class="form-control" id="id" value="${list.id }" placeholder = "아이디는 익명으로 처리됩니다." readonly>
				</div>


			</div>
			<div class="form-group">
				<label for="title">제목</label> 
				<input name="ftitle" type="text"	class="form-control" id="title" placeholder="제목을 입력하세요."required="required" value = '${list.ftitle }'>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea rows="10" name="fcontent" class="form-control" id="content">${list.fcontent }</textarea>
			</div>
			<div class="form-row"></div>
			<div class="form-group"></div>
			<div class="form-group">
				<label for="file">첨부파일</label> <input type="file" name="file"
					class="form-control" id="file">
				</textarea>
			</div>

			<button type="submit" class="btn btn-primary">수정</button>
		</form>
		<br>
		<br>
		<br>

		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>
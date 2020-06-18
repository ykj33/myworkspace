<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script type="text/javascript">
	function managerdelete(num) {
		var isOk = confirm("삭제하시겠습니까?");
		if (isOk == true) {
			location.href = "reviewmanagerdelete.do?num=" + num;
		}
	}
</script>
<title>IT 제품 리뷰</title>
<!-- 파비콘 적용 -->
<link rel = "shorcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
<div style="padding: 20px 70px 0px 70px;">
		<jsp:include page="header.jsp" />
<h1>자유게시판</h1>
<table class="table table-striped">
		 <colgroup>
            <c:if
               test="${login.property.equals('customer')||empty login.property}">
               <col width="8%" />
               <col width="24%" />
               <col width="16%" />
               <col width="16%" />
               <col width="16%" />
               <col width="12%" />
               <col width="8%" />
            </c:if>
            <c:if
               test="${login.property.equals('admin')||login.property.equals('manager') }">
               <col width="7%" />
               <col width="21%" />
               <col width="14%" />
               <col width="14%" />
               <col width="14%" />
               <col width="10%" />
               <col width="7%" />
               <col width="13%" />
            </c:if>
         </colgroup>
		
			<thead  bgcolor = "pink">
				<tr>
					<th>번호</th>
					<th>제목</th>
					
					<th>작성일</th>
					<th>조회수</th>
				

					<c:if
						test="${login.property.equals('admin')||login.property.equals('manager') }">
						<th>삭제</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<%-- <tr style="font-weight:bold">
					<!-- EL로 표기하기 위한 데이터 바인딩 -->
					<%ReviewDTO notice = (ReviewDTO) request.getAttribute("notice"); %>
						<td>${notice.num }</td>
						<td><a href="reviewread.do?num=${notice.num }">${notice.title }</a></td>
						<td>${notice.id }</td>
						<td>${notice.category }</td>
						<td><c:choose>
							<c:when test="${fn:length(notice.writeday)>10 }">
								<c:out value="${fn:substring(notice.writeday,0,10)}" />
							</c:when>
						</c:choose></td>
						<td>${notice.readcnt }</td>
						<td>${notice.starpoint }</td>
						<c:if
						test="${login.property.equals('admin')||login.property.equals('manager') }">
						<td></td>
					</c:if>
					</tr> --%>
					<c:forEach items="${list }" var="dto">
				
				<tr>
					<td>${dto.fnum }</td>
					<td><a href="freeread.do?fnum=${dto.fnum }">${dto.ftitle }</a></td>
					<td><c:choose>
							<c:when test="${fn:length(dto.fwriteday)>10 }">
								<c:out value="${fn:substring(dto.fwriteday,0,10)}" />
							</c:when>
						</c:choose></td>
					<td>${dto.freadcnt }</td>
					
					<c:if
						test="${login.property.equals('admin')||login.property.equals('manager') }">
						<td>
							<button onclick="managerdelete('${dto.fnum}')">글 삭제</button>
						</td>
					</c:if>
				</tr>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		 <div style="float: right">
      <c:if test="${!empty login}">
         <button type="button" class="btn btn-primary btn-lg"
            onclick="location.href='freeinsertui.do'">글쓰기</button>
      </c:if>
      </div>
		   <br> <br> <br> <br>
      
      <jsp:include page="footer.jsp" />
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/common/head.jsp"%>
</head>
<body>
	<!-- NAV -->
	<%@ include file="/common/nav.jsp" %>
	
	<div id="section" class="container-fluid">
		<div id="tboard">
			<h1>회원 관리</h1>
			<table class="table table-striped">
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>이메일</th>
					<th>관리</th>
				</tr>
				<c:forEach var="member" items="${members}" varStatus="vs">
					<tr>
						<td>${member.user_id}</td>
						<td>${member.user_name}</td>
						<td>${member.email_id}@${member.email_domain}</td>
						<td><a class="btn btn-danger" href="${root}/member?action=delete&user_id=${member.user_id}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- FOOTER -->
	<%@ include file="/common/footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/common/head.jsp"%>
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
						<td><a
							href="${root}/boardController?action=detail&articleNo=${member.user_id}">${member.user_id}</a></td>
						<td>${member.user_name}</td>
						<td>${member.email_id}@${member.email_domain}</td>
						<td><button class="btn btn-danger">삭제</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<a href="${root}/index.jsp">Home으로 돌아가기</a>
</body>
</html>
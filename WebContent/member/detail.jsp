<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>detail</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../assets/css/member.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:set value="${pageContext.request.contextPath}" var="root"></c:set>

	<%@ page import="model.MemberDto"%>
	<%
	MemberDto getCurSessionInfo = (MemberDto) session.getAttribute("login");
	String user_id = getCurSessionInfo.getUser_id();
	String user_name = getCurSessionInfo.getUser_name();
	String user_password = getCurSessionInfo.getUser_password();
	String email_id = getCurSessionInfo.getEmail_id();
	String email_domain = getCurSessionInfo.getEmail_domain();
	Boolean available = getCurSessionInfo.isAvailable();
	%>
	<div class="container mt-3">
		<h2>회원정보</h2>
		<form action="../member" method="post">
			<input type="hidden" id="action" name="action" value="update">
			<div class="mb-3 mt-3">
				<label for="user_id">사용자 아이디</label> <input type="text"
					class="form-control member-detail" id="user_id" value=<%=user_id%>
					name="user_id" readonly>
			</div>
			<div class="mb-3 mt-3">
				<label for="user_name">사용자 이름</label> <input type="text"
					class="form-control member-detail" id="user_name"
					value=<%=user_name%> name="user_name" readonly>
			</div>
			<div class="mb-3">
				<label for="user_password">사용자 패스워드</label> <input type="text"
					class="form-control member-detail" id="user_password"
					value="********" name="user_password" readonly>
			</div>
			<div class="mb-1">
				<label for="email_id">이메일</label>
			</div>
			<div class="input-group mt-1 mb-3">
				<input type="text" class="form-control member-detail" id="email_id"
					value=<%=email_id%> name="email_id" readonly>@ <input
					type="text" class="form-control member-detail" id="email_domain"
					value=<%=email_domain%> name="email_domain" readonly>

			</div>
			<div class="mb-3">
				<label for="available">이용가능 여부</label> <input type="text"
					class="form-control member-detail" id="available"
					value=<%=available%> name="user_password" readonly>
			</div>
			<button type="submit" class="btn btn-primary">회원정보 수정</button>
		</form>
		<a href="${root}/index.jsp">Home으로 돌아가기</a>
	</div>
	
</body>
</html>
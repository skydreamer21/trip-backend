<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>
<div class="contaianer mt-3">
  <h2>로그인</h2>
  <form action="${root}/member" method="post">
    <input type="hidden"  id="action" name="action" value="loginaf">
    <div class="mb-3 mt-3">
      <label for="user_id">사용자 아이디:</label>
      <input type="text" class="form-control" id="user_id" placeholder="아이디 입력" name="user_id">
    </div>
    <div class="mb-3">
      <label for="user_password">사용자 패스워드:</label>
      <input type="password" class="form-control" id="user_password" placeholder="패스워드입력" name="user_password">
    </div>
    <button type="submit" class="btn btn-primary">로그인</button>&nbsp;&nbsp;<a href='${root}/member?action=registry'>회원가입 </a>
  </form>
</div>
</body>
</html>
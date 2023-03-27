<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>registry</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>
<div class="container mt-3">
  <h2>회원가입</h2>
  <form action="${root}/member" method="post">
    <input type="hidden"  id="action" name="action" value="registryaf">
    <div class="mb-3 mt-3">
      <label for="user_id">사용자 아이디</label>
      <input type="text" class="form-control" id="user_id" placeholder="아이디 입력" name="user_id">
    </div>
    <div class="mb-3 mt-3">
      <label for="user_name">사용자 이름</label>
      <input type="text" class="form-control" id="user_name" placeholder="이름 입력" name="user_name">
    </div>
    <div class="mb-3">
      <label for="user_password">사용자 패스워드</label>
      <input type="password" class="form-control" id="user_password" placeholder="패스워드입력" name="user_password">
    </div>
     <div class="mb-1">
       <label for="email_id">이메일</label>
    </div>
      <div class="input-group mt-1 mb-3">
       <input type="text" class="form-control" id="email_id" placeholder="이메일" name="email_id" >@
    <select class="form-select" id="email_domain" name="email_domain">
      <option value="naver.com">naver.com</option>
      <option value="ssafy.com">ssafy.com</option>
      <option value="google.com">google.com</option>
    </select>
  </div>
    <button type="submit" class="btn btn-primary">회원가입</button>
  </form>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>index</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>
<div class="contaianer mt-3">

  <a href='${root}/member?action=login'> 로그인 </a>
  <a href='${root}/member?action=registry'> 회원가입 </a>
  <a href='${root}/member?action=detail'> 회원정보 조회</a>
</div>
</body>
</html>

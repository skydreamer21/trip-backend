<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/common/head.jsp" %>
</head>
<body>
<div class="contaianer mt-3">

  <a href='${root}/member?action=login'> 로그인 </a>
  <a href='${root}/member?action=registry'> 회원가입 </a>
  <a href='${root}/member?action=detail'> 회원정보 조회</a>
  <a href='${root}/attraction/attraction.jsp'>관광지 조회</a>
  <a href='${root}/boardController?action=boardwrite'>글쓰기</a>
  <a href='${root}/boardController?action=boardlist'>글목록</a>
</div>
</body>
</html>

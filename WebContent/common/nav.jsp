<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Navigation-->
<nav class="navbar navbar-light bg-light static-top">

	<div class="container">
		<a class="navbar-brand" href="#!">EnjoyTrip</a>

		<div class="contaianer mt-3">
			<c:if test="${login ne null}">
				<span>${login.user_id}님 반갑습니다.</span>
				<a class="btn btn-primary" href='${root}/member?action=logout'>
					로그아웃</a>
				<a class="btn btn-primary" href='${root}/member?action=detail'>
					회원정보 조회</a>
				<a class="btn btn-primary" href='${root}/attraction/attraction.jsp'>관광지
					조회</a>
				<a class="btn btn-primary"
					href='${root}/boardController?action=boardwrite'>글쓰기</a>
				<a class="btn btn-primary"
					href='${root}/boardController?action=boardlist'>글목록</a>
				<c:if test="${login.user_id eq 'admin'}">
					<a class="btn btn-warning"
						href='${root}/boardController?action=announcement'>공지사항 등록</a>
					<a class="btn btn-warning" href='${root}/member?action=memberList'>회원
						관리</a>
				</c:if>
			</c:if>

			<c:if test="${login eq null}">
				<a class="btn btn-primary" href='${root}/member?action=login'>
					로그인 </a>
				<a class="btn btn-primary" href='${root}/member?action=registry'>
					회원가입 </a>
			</c:if>
		</div>
	</div>
</nav>

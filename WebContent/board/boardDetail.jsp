<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<style type="text/css">
#section {
	margin: auto;
}

#tboard {
	margin: auto;
}

#tboard>table {
	margin: auto;
	width: 80%;
	border: 1px solid #aabbcc;
}
</style>
<%@include file="/common/head.jsp"%>
</head>
<body>
	<!-- NAV -->
	<%@ include file="/common/nav.jsp" %>

	<div id="section">
		<div id="tboard">
			<h1>상세보기</h1>
			<table>
				<col width="40%">
				<col width="60%">
				<%--  		<tr>
 			<th>번호</th><td><input type="text" name="article_no" readonly="readonly"
 			width="50" value="${board.article_no}"/></td>
 		</tr> --%>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="user_id" readonly="readonly"
						width="50" value="${board.userId}" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" readonly="readonly"
						width="50" value="${board.title}" /></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><input type="text" name="register_time"
						readonly="readonly" width="50" value="${board.registerTime}" /></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td><input type="text" name="hit" readonly="readonly"
						width="50" value="${board.hitCount}" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" readonly="readonly" rows="10"
							cols="50">${board.content}</textarea></td>
				</tr>

			</table>
		</div>
		<div style="float: right">
			<form style="display: inline" action="${root}/boardController"
				method="post">
				<input type="hidden" name="action" value="updateBoard" /> <input
					type="hidden" name="articleNo" value="${board.articleNo}" /> <input
					type="submit" value="수정" />
			</form>
			<button id="board-delete">삭제</button>
			<div>
				<a href="${root}/boardController?action=boardlist">글 목록으로 돌아가기</a>
			</div>
		</div>
	</div>
	<!-- FOOTER -->
	<%@ include file="/common/footer.jsp" %> 
	<script>
		const deleteBtn = document.querySelector("#board-delete");
		deleteBtn.addEventListener("click", (event) => {
			const result = confirm("글을 삭제 하시겠습니까?");
			if (result === true) {
				let deleteUrl = "${root}/boardController?action=delete&articleNo=${board.articleNo}";
				fetch(deleteUrl, {method: "GET"})
					.then((response) => {
						// console.log(response);
						location.href=response.url;
					});
			}
		})
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
<%@include file="/common/head.jsp"%>
</head>
<body>
	<!-- NAV -->
	<%@ include file="/common/nav.jsp" %>
	<div id="section">
		<div id="tboard">
			<c:if test="${announcement ne null}">
				<h1>공지사항 등록</h1>
			</c:if>
			<c:if test="${announcement eq null}">
				<h1>글작성</h1>
			</c:if>
			<form action="${root}/boardController" method="post">
				<c:if test="${board ne null}">
					<input type="hidden" name="action" value="boardUpdateaf" />
					<input type="hidden" name="articleNo" value="${board.articleNo}" />
				</c:if>
				<c:if test="${board eq null}">
					<input type="hidden" name="action" value="boardwriteaf" />
				</c:if>
				<c:if test="${announcement ne null}">
					<input type="hidden" name=announcement value="1" />
				</c:if>
				<table>
					<col width="40%">
					<col width="60%">
					<tr>
						<th>작성자</th>
						<td><input type="text" name="userId" readonly="readonly"
							width="50" value="${login.user_id}" /></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" width="50"
							value="${board.title}" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" rows="10" cols="50">${board.content}</textarea>
						</td>
					</tr>
					<tr>
						<c:if test="${board ne null}">
							<td colspan="2"><input type="submit" value="수정하기" /></td>
						</c:if>
						<c:if test="${board eq null}">
							<td colspan="2"><input type="submit" value="글쓰기" /></td>
						</c:if>

					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- FOOTER -->
	<%@ include file="/common/footer.jsp" %> 
</body>
</html>
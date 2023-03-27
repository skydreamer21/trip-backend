<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<%@include file="/common/head.jsp"%>
	<div id="section">
		<div id="tboard">
			<h1>글작성</h1>
			<form action="${root}/boardController" method="post">
				<c:if test="${board ne null}">
					<input type="hidden" name="action" value="boardUpdateaf" />
					<input type="hidden" name="articleNo" value="${board.articleNo}" />
				</c:if>
				<c:if test="${board eq null}">
					<input type="hidden" name="action" value="boardwriteaf" />
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
</body>
</html>
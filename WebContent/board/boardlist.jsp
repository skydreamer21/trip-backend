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
			<h1>글목록</h1>
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="board" items="${boards}" varStatus="vs">
					<tr>
						<td><a
							href="${root}/boardController?action=detail&articleNo=${board.articleNo}">${vs.count}</a></td>
						<td>${board.title}</td>
						<td>${board.userId}</td>
						<td>${board.hitCount}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
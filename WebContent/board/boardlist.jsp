<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<div id="section">
		<div id="tboard">
			<h1>글목록</h1>
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>조회수</th>
				</tr>
				<c:foreach var="board" items="${boards}" varStatus="vs">
					<tr>
						<td><a href="../board?action=detail&acticleNo=${board.articleNo}">${vs.count}</a></td>
						<td>${board.title}</td>
						<td>${board.userId}</td>
						<td>${board.hitCount}</td>
					</tr>
				</c:foreach>
			</table>
		</div>
	</div>
</body>
</html>
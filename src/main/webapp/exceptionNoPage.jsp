<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
</head>
<body>

	<div class="container py-4">
		<jsp:include page="menu.jsp" />
		<div class="jumbotron">
			<div class="container">
				<h2 class="alert alert-danger">요청하신 페이지를 찾을 수 없습니다.</h2>
			</div>
		</div>

		<div class="container">
			<p><%=request.getRequestURL()%></p>
			<p>
				<a href="books" class="btn btn-secondary">도서 목록&raquo;</a>
		</div>

	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="dto.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<body>

	<div class="container py-4"> 
	
		<%@ include file="menu.jsp" %>
		
		<div class = "p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서정보</h1>
				<p class="col-md-8 fs-4">BookInfo</p>
			</div>
		</div>
	</div>

	<%
		Book book = (Book)request.getAttribute("book");
	%>

	<div class="row align-items-md-stretch">
		<div class = "col-md-5">
			<img src="./resources/images/<%=book.getFilename() %>" style="width : 70%">
		</div>
	
		<div class="col-md-6">
			<h3><b><%=book.getName() %></b></h3>
			<p><b>도서코드</b> : <span class="badge text-bg-danger"><%=book.getBookId() %></span>
			<p><b>저자</b> :<%=book.getAuthor() %>
			<p><b>출판사</b> : <%=book.getPublisher() %>
			<p><b>출판일</b> : <%=book.getReleaseDate() %>
			<p><b>분류</b> :  <%=book.getCategory() %>
			<p><b>재고수</b> : <%=book.getUnitsInStock() %>
			<h4><%=book.getUnitPrice() %>원</h4>
			<p><a href="#" class="btn btn-info">도서주문 &raquo;</a>
			<a href="books" class="btn btn-secondary">도서 목록 &raquo;</a>
		</div>
	</div>
	<jsp:include page = "footer.jsp" />
</body>
</html>
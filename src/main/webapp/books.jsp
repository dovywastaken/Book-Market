<%@page import="java.util.ArrayList"%>
<%@ page import ="dto.Book" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="dao.BookRepository" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
</head>
<body>
	<div class="container py-4">
		<%@ include file = "menu.jsp" %>
		<div class ="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class ="display-5 fw-bold">도서 목록</h1>
				<p class="col-md8 fs-4"> BookList</p>
			</div>
		</div>
		

		
		<%
			ArrayList<Book> listOfBooks = (ArrayList<Book>) session.getAttribute("booklist");
			if (listOfBooks == null) {
			    listOfBooks = (ArrayList<Book>) request.getAttribute("booklist");
			}

		%>
		
		

		<div class="row align-items-md-stretch text-center">
			<%
				for(int i=0; i< listOfBooks.size(); i++)
				{
					Book book = listOfBooks.get(i);
			%>
			
			<div class="col-md-4">
				<div class = "h-100 p-2">
					<img src="./resources/images/<%=book.getFilename() %>" style="width : 250; height : 350"/>
					<h5><b><%=book.getName() %></b></h5>
					<p> <%=book.getAuthor() %>
					<br> <%=book.getPublisher() %> | <%= book.getUnitPrice() %>원
					<p> <%=book.getDescription().substring(0,60) %>...
					<p> <%=book.getUnitPrice() %>원
					<p> <a href="./book?id=<%=book.getBookId()%>" class="btn btn-secondary" role="button" method="get"> 상세 정보 &raquo;</a>
				</div>
			</div>
			
			<%
				}
			%>
		</div>
		<%@ include file = "footer.jsp" %>
	</div>
</body>
</html>
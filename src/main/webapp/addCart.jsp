<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="dto.Book" %>
<%@ page import ="dao.BookRepository" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		if(id == null || id.trim().equals("")) //갖고온 id 값이 없으면 books로 돌려보내기
		{
			response.sendRedirect("books.jsp");
			return;
		}
		
		BookRepository dao = BookRepository.getInstance(); //싱글턴 방식

		Book book = dao.getBookById(id); //리자피토리에서 id에 맞는 book dto 하나를 들고 book 변수에 집어 넣는다
		if(book == null) //만약 book 변수가 값이 없다면
		{
			response.sendRedirect("exceptionNoBookId.jsp"); //예외처리 페이지로 보내자
		}

		ArrayList<Book> goodsList = dao.getAllBooks(); //
		Book goods = new Book();
		for(int i = 0; i< goodsList.size(); i++)
		{
			goods = goodsList.get(i);
			if(goods.getBookId().equals(id))
			{
				break;
			}
		}

		ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("cartlist");
		if(list == null)
		{
			list = new ArrayList<Book>();
			session.setAttribute("cartlist", list);
		}
		
		
		int cnt = 0;
		Book goodsQnt = new Book();
		
		for (int i=0; i < list.size(); i++)
		{
			goodsQnt = list.get(i);
			if(goodsQnt.getBookId().equals(id))
			{
				cnt++;
				int orderQuantity = goodsQnt.getQuantity() + 1;
				goodsQnt.setQuantity(orderQuantity);
			}
		}
		
		if (cnt ==0)
		{
			goods.setQuantity(1);
			list.add(goods);
		}
		
		response.sendRedirect("book.jsp?id = " + id);
	%>
</body>
</html>
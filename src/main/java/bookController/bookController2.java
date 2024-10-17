package bookController;

import java.io.IOException;
import java.util.ArrayList;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/book")
public class bookController2 extends HttpServlet
{
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리 
		String id = (String)req.getParameter("id");
		
		//모델이동  
		BookRepository bookRepository = BookRepository.getInstance(); //싱글턴 방식으로 생성된 객체를 인스턴스를 가져오는 과정
		Book book = bookRepository.getBookById(id);
		
		if (book == null) {
            System.out.println("No book found with id: " + id);
        }
		
		//이동  
		req.setAttribute("book", book);
		
		RequestDispatcher rd = req.getRequestDispatcher("book.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리
		req.setCharacterEncoding("UTF-8");
		
		String filename = "";
		String realFolder = req.getServletContext().getRealPath(filename + "resources\\images");
		int maxSize = 5*1024*1024;
		String encType ="utf-8";
		
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		System.out.println(realFolder);
		String bookId = multi.getParameter("bookId");
		System.out.println(bookId);
		String name = multi.getParameter("name");
		System.out.println(name);
		String unitPrice = multi.getParameter("unitPrice");
		System.out.println(unitPrice);
		String author = multi.getParameter("author");
		System.out.println(author);
		String publisher = multi.getParameter("publisher");
		System.out.println(publisher);
		String releaseDate = multi.getParameter("releaseDate");
		System.out.println(releaseDate);
		String description = multi.getParameter("description");
		System.out.println(description);
		String category = multi.getParameter("category");
		System.out.println(category);
		String unitInStock = multi.getParameter("unitInStock");
		System.out.println(unitInStock);
		String condition = multi.getParameter("condition");
		System.out.println(condition);
		String fileName = multi.getFilesystemName("BookImage");
		System.out.println(fileName);
		
		Integer price;
		
		if (unitPrice.isEmpty()) 
		{
			price = 0;
		}
		else 
		{
			price=Integer.valueOf(unitPrice);
		}
		
		long stock;
		
		if(unitInStock.isEmpty()) 
		{
		    stock = 0;
		}
		else 
		{
		    stock = Long.valueOf(unitInStock);
		}

		
		BookRepository dao = BookRepository.getInstance();
		
		Book newBook = new Book();
		newBook.setBookId(bookId);
		newBook.setName(name);
		newBook.setUnitPrice(price);
		newBook.setAuthor(author);
		newBook.setPublisher(publisher);
		newBook.setPublisher(releaseDate);
		newBook.setDescription(description);
		newBook.setCategory(category);
		newBook.setUnitsInStock(stock);
		newBook.setCondition(condition);
		newBook.setFilename(fileName);
		
		dao.addBook(newBook);
		
		ArrayList<Book> list = dao.getAllBooks();
		
		 HttpSession session = req.getSession();
		 session.setAttribute("booklist", list);
		//메서드 반환값이 여러개의 객체 Book 이기 때문에 ArrayList를 사용하는데 이 변수에 담을 객체의 종류를 Book으로 제한하기 위해 <Book>을 적는
		
		//모델 이동

		
		//이동


		 resp.sendRedirect("books.jsp");
		
	}
}

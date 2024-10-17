package bookController;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books") //menu.jsp에 있는 a태그와 연결되어 해당 a태그를 누르면 이 서블릿이 실행됨
public class bookController1 extends HttpServlet
{

	@Override //인스턴스 들고 북리파지터리에 있는 객체들 전부 들고 books.jsp로 가는 코드
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		BookRepository bookRepository = BookRepository.getInstance(); //싱글턴 방식으로 생성된 객체를 인스턴스를 가져오는 과정
		ArrayList<Book> list = bookRepository.getAllBooks();
		//메서드 반환값이 여러개의 객체 Book 이기 때문에 ArrayList를 사용하는데 이 변수에 담을 객체의 종류를 Book으로 제한하기 위해 <Book>을 적는
		req.setAttribute("booklist", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("books.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

	}

}

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
import jakarta.servlet.http.HttpSession;

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
		
		//전처리
		String id = req.getParameter("id");
		System.out.println("book.jsp 에서 컨트롤러로 넘어옴 / " + id);

		
		if (id == null || id.trim().equals("")) 
		{
			resp.sendRedirect("books.jsp");
			return;
		}

		
		//모델이동
		BookRepository dao = BookRepository.getInstance();
		Book book = dao.getBookById(id);

		if (book == null) {
			resp.sendRedirect("exceptionNoBookId.jsp");
			return;
		}

		ArrayList<Book> goodsList = dao.getAllBooks(); //dao에 있는 모든 책 다가져와서 ArrayList에 집어넣기
		Book goods = new Book(); //dto 생성
		for(int i=0; i<goodsList.size(); i++) 
		{
			goods = goodsList.get(i);
			if(goods.getBookId().equals(id))  //book.jsp에서 주문하기 버튼을 눌려서 가져온 bookId가 dao 안에있는 책이랑 같은지 아닌지
			{
				break; //같은걸 찾으면 같은 id를 가진 dto가 goods 변수에 들어감
			}
		}
		
		HttpSession session = req.getSession(); //세션 객체 생성
		ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("cartlist"); //또 다른 ArrayList에 cartlist라는 데이터를 세션에서 가져오는데
		if (list == null)  //만약 세션에서 가져온 값이 없으면
		{
			list = new ArrayList<Book>(); //새로 ArrayList 만들어서 list에 넣고
			session.setAttribute("cartlist", list); //방금 만든 list를 세션에 carlist라는 이름으로 저장한다
		}
		
		int cnt=0; //카운트 변수 초기화
		Book goodsQnt = new Book(); //새로운 dto 생성해서 goodsQnt에 저장
		
		
		for(int i = 0; i<list.size(); i++) 
		{
			goodsQnt = list.get(i);
			if(goodsQnt.getBookId().equals(id))
			{
				cnt++;
				int orderQuantity = goodsQnt.getQuantity() + 1;
				goodsQnt.setQuantity(orderQuantity);
			}
		}
		
		if(cnt == 0) 
		{
			goods.setQuantity(1);
			list.add(goods);
		}		
		
		
		//이동
		resp.sendRedirect("cart.jsp");
	}

}

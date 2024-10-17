package dao;

import java.util.ArrayList;

import dto.Book;

public class BookRepository 
{
	//BookRepository 클래스에 다른 클래스나 jsp에서 접근이 가능하도록 하는 작업
	private static BookRepository bookrepository = new BookRepository(); //다른데서 직접 생성하지 못하도록 여기에서만 BookRepository 객체를 생성함 (싱글턴방식)
	//왜 싱글턴 방식으로 다른 클래스에서 인스턴스 만들기를 막는 이유는 BookRepository가 독서관이라 생각했을 때 같은 책을 가진 도서관 여러개를 만들면 나중에는 결국 다 다른 도서관이 되버리기
	//때문에 하나의 도서관에서 책을 가져가도록 만들기 위해 하나의 도서관에 대한 접근권한만 주는것이라 생각하면 된다.
	public static BookRepository getInstance() //대신 다른데서 객체생성이 가능하도록 getInstance()로만 객체생성이 가능하도록 함
	{
		return bookrepository;
	}

	
	private ArrayList<Book> listOfBooks = new ArrayList<Book>();
	
	public BookRepository() 
	{
		Book book1= new Book("ISBN1234","C# 프로그래밍", 27000);
		book1.setAuthor("우재남");
		book1.setDescription("C#을 처음 접하는 독자를 대상으로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 중요한 내용은 응용 예제, 퀴즈, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다.");
		book1.setPublisher("한빛아카데미");
		book1.setCategory("IT모바일");
		book1.setUnitsInStock(1000);	
		book1.setReleaseDate("2022/10/06");
		book1.setFilename("ISBN1234.jpg");
		
		Book book2 = new Book("ISBN1235","자바마스터", 30000);
		book2.setAuthor("송미영");
		book2.setDescription("자바를 처음 배우는 학생을 위해 자바의 기본 개념과 실습 예제를 그림을 이용하여 쉽게 설명합니다. 자바의 이론적 개념→기본 예제→프로젝트 순으로 단계별 학습이 가능하며, 각 챕터의 프로젝트를 실습하면서 온라인 서점을 완성할 수 있도록 구성하였습니다.");
		book2.setPublisher("한빛아카데미");
		book2.setCategory("IT모바일");
		book2.setUnitsInStock(1000);		
		book2.setReleaseDate("2023/01/01");
		book2.setFilename("ISBN1235.jpg");
		
		Book book3= new Book("ISBN1236","파이썬 프로그래밍", 30000);
		book3.setAuthor("최성철");
		book3.setDescription(" 파이썬으로 프로그래밍을 시작하는 입문자가 쉽게 이해할 수 있도록 기본 개념을 상세하게 설명하며, 다양한 예제를 제시합니다. 또한 프로그래밍의 기초 원리를 이해하면서 파이썬으로 데이터를 처리하는 기법도 배웁니다.");
		book3.setPublisher("한빛아카데미");
		book3.setCategory("IT모바일");
		book3.setUnitsInStock(1000);	
		book3.setReleaseDate("2023/01/01");
		book3.setFilename("ISBN1236.jpg");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
		
	}
	
	public ArrayList<Book> getAllBooks() //모든 Book 객체 가져오기	
	{
		return listOfBooks;
	}
	
	
	public Book getBookById(String bookId) 
	{
		Book bookById=null;
		
		for (int i=0; i<listOfBooks.size(); i++) 
		{
			Book book = listOfBooks.get(i);
			if(book != null && book.getBookId() != null && book.getBookId().equals(bookId)) 
			{
				bookById = book;
				break;
			}
		}
		return bookById;
	}
	
	public void addBook(Book book) //책 더해줌 
	{
		listOfBooks.add(book);
	}
	
	
}

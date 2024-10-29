package bookController;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class addCart_controller extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("book페이지에서 장바구니 버튼 눌려서 doGet 메서드로 장바구니 페이지로 들어옴");
		Cookie[] cookies = req.getCookies();
		for(int i=0; i<cookies.length; i++)
		{
			System.out.println("설정된 쿠키의 속성 이름 [ " + i + " ] : " + cookies[i].getName() + "<br>");
			System.out.println("설정된 쿠키의 속성 값 [ " + i + " ] : " + cookies[i].getValue() + "<br>");
			System.out.println("======================================= <br>");
		}
		
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		//전처리
		req.setCharacterEncoding("utf-8");
		
		Cookie cartId = new Cookie("Shipping_cartId", URLEncoder.encode(req.getParameter("cartId"), "utf-8"));
		System.out.println("cartID 쿠키 담음" + cartId);
		
		Cookie name = new Cookie("Shipping_name", URLEncoder.encode(req.getParameter("name"), "utf-8"));
		System.out.println("name 쿠키 담음" + name);
		
		Cookie shippingDate = new Cookie("Shipping_shippingDate", URLEncoder.encode(req.getParameter("shippingDate"), "utf-8"));
		System.out.println("shippingDate 쿠키 담음" + shippingDate);
		
		Cookie country = new Cookie("Shipping_country", URLEncoder.encode(req.getParameter("country"), "utf-8"));
		System.out.println("country 쿠키 담음" + country);
		
		Cookie zipCode = new Cookie("Shipping_zipCode", URLEncoder.encode(req.getParameter("zipCode"), "utf-8"));
		System.out.println("zipCode 쿠키 담음" + zipCode);
		
		Cookie addressName = new Cookie("Shipping_addressName", URLEncoder.encode(req.getParameter("addressName"), "utf-8"));
		System.out.println("addressName 쿠키 담음" + addressName);
		
		cartId.setMaxAge(24 * 60 * 60);
		name.setMaxAge(24 * 60 * 60);
		shippingDate.setMaxAge(24 * 60 * 60);
		country.setMaxAge(24 * 60 * 60);
		zipCode.setMaxAge(24 * 60 * 60);
		addressName.setMaxAge(24 * 60 * 60);
		
		//모델이동
		
		//이동
		resp.addCookie(cartId);
		resp.addCookie(name);
		resp.addCookie(shippingDate);
		resp.addCookie(country);
		resp.addCookie(zipCode);
		resp.addCookie(addressName);
		
		resp.sendRedirect("orderConfirmation.jsp");
	}

}

package filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFilter implements Filter
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		System.out.println("BookMarket 초기화...");
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException 
	{
		System.out.println("접속한 클라이언트 IP : " + req.getRemoteAddr());
		long start = System.currentTimeMillis();
		System.out.println("접근한 URL 경로 : " + getURLPath(req));
		System.out.println("요청 처리 시작 시각 : " + getCurrentTime());
		chain.doFilter(req, resp);
		
		long end = System.currentTimeMillis();
		System.out.println("요청 처리 종료 시각 : " + getCurrentTime());
		System.out.println("요청 처리 소요 시간 : " + (end-start)+ "ms ");
		System.out.println("=================================================");
	}
	
	@Override
	public void destroy() 
	{
		
	}

	private String getURLPath(ServletRequest request) 
	{
		HttpServletRequest req;
		String currentPath = "";
		String queryString = "";
		if(request instanceof HttpServletRequest) 
		{
			req=(HttpServletRequest)request;
			currentPath = req.getRequestURI();
			queryString = req.getRequestURI();
			queryString = queryString == null ? "" : "?" +queryString;
		}
		return currentPath+queryString;
	}
	
	private String getCurrentTime()
	{
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}




}

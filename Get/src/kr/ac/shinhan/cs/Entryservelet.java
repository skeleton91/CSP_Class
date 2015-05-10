package kr.ac.shinhan.cs;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Entryservelet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String token_ID = null;
	
		
		String token = UUID.randomUUID().toString();
		
		HttpSession session = req.getSession();
		
		Cookie[] cookieList = req.getCookies();
		if(( session.getAttribute(token_ID) == token))
		{
			
			cookieList = req.getCookies();
			
			session.setAttribute("Session_ID", null);
			session.setAttribute("Session_ID", token);
			
			resp.sendRedirect("/index.html");
		}
		
		else{
			resp.sendRedirect("/login.html");
		}
	}

}

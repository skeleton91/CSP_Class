package kr.ac.shinhan.cs;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Entryservelet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String id = null;
	      String token = null;
	      boolean success = false;
	      
	      
	      Query qry2 = MyPersistenceManager.getManager()
	            .newQuery(UserLoginToken.class);
	      List<UserLoginToken> ulog = (List<UserLoginToken>) qry2.execute();
	      
	      
	      Cookie[] cookies = req.getCookies();
	      
	      if (cookies == null || cookies.length == 0) {
	         resp.sendRedirect("/login.html");
	      }

	      else 
	      {   
	         for (Cookie c : cookies) 
	         {
	            if (c.getName().equals("token_ID")) 
	            {
	               token = c.getValue();
	            }               
	         }               
	         
	         for (UserLoginToken ult : ulog)
	         {
	            if (ult.getToken().equals(token)) 
	            {
	               id = ult.getUserAccount();   
	               token = UUID.randomUUID().toString();
	               ult.setToken(token);
	               Cookie cookieToken = new Cookie("token_ID", token);
	               cookieToken.setMaxAge(60*60*24*30);
	               resp.addCookie(cookieToken);
	               success = true;   
	            }            
	         }                     
	      }               
	      if (success)
	      {
	         HttpSession session = req.getSession();
	         session.setAttribute("Session_ID",id);
	         resp.sendRedirect("/index.html");
	      }
	   } 
}

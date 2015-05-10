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

public class LogoutServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		
		String token_ID = null;
		String expireDate = req.getParameter("expireDate");
		String id = req.getParameter("id");
		String userID = req.getParameter("userID");
		String check_in = req.getParameter("remember");
		String token = UUID.randomUUID().toString();
		
		
		
		
		
		
		MyPersistenceManager.getManager();

		Query qry = MyPersistenceManager.getManager().newQuery(UserAccount.class);

		qry.setFilter("userID == idParam");
		qry.declareParameters("String idParam");

		List<UserAccount> userAccount = (List<UserAccount>) qry.execute(id);
	
		
		Cookie[] cookieList = req.getCookies();

		for (Cookie cookie : cookieList)

		{
			if((check_in != null))

			{
				HttpSession session = req.getSession();
				
				
				
				session.invalidate();
				
				cookie.setValue(null);

				cookie.setMaxAge(0);

				
				
				resp.addCookie(cookie);
				
				

			}
			
			resp.sendRedirect("/login.html");
			}

		}
	}


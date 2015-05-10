package kr.ac.shinhan.cs;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		
		Long key = null;
		HttpSession session = req.getSession(false);


		key = (Long) session.getAttribute("ck_key");
		
		if(key != null){
		
		Cookie[] cookieList = req.getCookies();

		for (Cookie cookie : cookieList)

		{
			if((cookie.getName().equals("token_ID")))

			{
				
				
				
				
				session.invalidate();
				
				cookie.setValue(null);

				cookie.setMaxAge(0);
				resp.addCookie(cookie);

				}
			}
				
			
				
				
				PersistenceManager pm = MyPersistenceManager.getManager();
				UserLoginToken ul = pm.getObjectById(UserLoginToken.class,key);
				pm.makePersistent(ul);
				

			}
			
			resp.sendRedirect("/login.html");
			}

		}
	


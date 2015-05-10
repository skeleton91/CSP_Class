package kr.ac.shinhan.cs;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServelet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String check_in = req.getParameter("remember");
		String expireData = req.getParameter("expireData");
		String token = UUID.randomUUID().toString();
		
		
		
		boolean success = false;
		
		MyPersistenceManager.getManager();

		Query qry = MyPersistenceManager.getManager().newQuery(UserAccount.class);
		
		qry.setFilter("userID == idParam");
		qry.declareParameters("String idParam");
		
		

		List<UserAccount> userAccount = (List<UserAccount>) qry.execute(id);
		

		
		
		

		if (userAccount.size() == 0) {
			success = false;
		}

		else if (userAccount.get(0).getPassword().equals(password)) {
			success = true;
			
			
		}

		else {
			success = false;
		}

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");

		if (!success) {
			resp.getWriter().println("Fail to login");
			resp.getWriter().println("<a href='login.html'>Login Again</a>");
		}

		if (success) {
			
			HttpSession session = req.getSession();
			
			session.setAttribute("Session_ID", id);
			
			if(check_in != null){
				
				
				
				 
				
				Cookie cookie = new Cookie("token_ID", token );

				cookie.setMaxAge(30 * 24 * 60 * 60);
				resp.addCookie(cookie);
				
				
				Calendar cal = Calendar.getInstance();
			    cal.setTime(new Date());
			    cal.add(Calendar.DATE, 30);
			   
			     
			    // 특정 형태의 날짜로 값을 뽑기 
			    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    String strDate = df.format(cal.getTime());
			    System.err.println(strDate);
				
				expireData = strDate;
				
				
				
				UserLoginToken ul = new UserLoginToken(token,id,expireData);
				PersistenceManager pm = MyPersistenceManager.getManager();
				pm.makePersistent(ul);

				
				Query qry1 = MyPersistenceManager.getManager().newQuery(UserLoginToken.class);
				
				List<UserLoginToken> log = (List<UserLoginToken>) qry1.execute(id);
				
				qry1.setFilter("userID == idParam");
				qry1.declareParameters("String idParam");
				
				UserLoginToken log1 = log.get(0);
				Long key = log1.getKey();
				
				session.setAttribute("ck_key",key);
				 
				
			}
			
			
			
			
			resp.sendRedirect("index.html");
		}

		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}

}
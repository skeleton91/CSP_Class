package kr.ac.shinhan.cs;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSevlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp,String key)	throws IOException {
	
		
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		TeamMember m = MyPersistenceManager.getMember(key);

		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		
		resp.getWriter().println("삭제되었습니다." + "<br>");
		
		resp.getWriter().println("<br>");
		resp.getWriter().println("<a href='/retrieve'>이전으로</a>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		pm.deletePersistent(m);
	}
}

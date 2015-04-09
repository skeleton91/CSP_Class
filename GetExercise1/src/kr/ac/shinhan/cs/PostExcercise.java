package kr.ac.shinhan.cs;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.shinhan.cs.TeamMember;
import kr.ac.shinhan.cs.MyPersistenceManager;

public class PostExcercise extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String uname = req.getParameter("uname");
		String socialNumber = req.getParameter("socialNumber");
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		TeamMember m = MyPersistenceManager.addMember(uname, socialNumber);
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("called PostExcercise.doPost() </br>");
		resp.getWriter().println("¿Ã∏ß : "+m.getName() +"<br>");
		resp.getWriter().println("¡÷πŒπ¯»£ : "+m.getSosialNum() +"<br>");
		resp.getWriter().println("∞¥√º ≈∞ : "+m.getKey() +"<br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
	}
}
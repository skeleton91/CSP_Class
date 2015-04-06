package kr.ac.shinhan.cs;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostExcercise extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
			
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("called PostExcercise.doPost() </br>");
		resp.getWriter().println("이름 : " + req.getParameter("uname") + " </br> ");
		resp.getWriter().println("주민번호 : " + req.getParameter("socialNumber") + "</br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
	}
}
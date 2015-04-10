package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProjectProfile extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		
		
		
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
	}
}

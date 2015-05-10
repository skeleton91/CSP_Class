package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Main extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String id = req.getParameter("id");

		Cookie[] cookieList = req.getCookies();

		for (Cookie c : cookieList) {

			if (c.getName().equals("loged_in_id"))

			{

				id = c.getValue();

				System.out.println("Hello " + id);

			}

			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain");

			resp.getWriter().println("<html>");
			resp.getWriter().println("<body>");

			resp.getWriter().println("</body>");
			resp.getWriter().println("</html>");

		}
	}
}
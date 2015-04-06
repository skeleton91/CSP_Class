package kr.ac.shinhan.cs;


import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class Get extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("팀 멤버 등록"+"<br>");
		resp.getWriter().println("이름 : " + req.getParameter("name") + " <br> ");
		resp.getWriter().println("학번 : " + req.getParameter("id") + "<br>");
		resp.getWriter().println("전화번호 : " + req.getParameter("num") + "<br>");
		resp.getWriter().println("메일주소 : " + req.getParameter("add") + "<br>");
		resp.getWriter().println("카카오톡 아이디 : " + req.getParameter("kaka") + "<br>");
		if(req.getParameter("chk_info") != null)
			resp.getWriter().println("팀장여부: 팀장"+"<br>");
		else
			resp.getWriter().println("팀장여부: 팀원"+"<br>");
		resp.getWriter().println("GitHub Id : " + req.getParameter("git") + "<br>");
		resp.getWriter().println("등록되었습니다." + "<br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
	}
}
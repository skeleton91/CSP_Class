package kr.ac.shinhan.cs;


import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class Get extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String num = req.getParameter("num");
		String add = req.getParameter("add");
		String kaka = req.getParameter("kaka");
		String git = req.getParameter("git");
		String chk_info = req.getParameter("chk_info");
		
		
			
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("팀 멤버 등록asdf");
		resp.getWriter().println("이름 : " + name + " <br> ");
		resp.getWriter().println("학번 : " + id + "<br>");
		resp.getWriter().println("전화번호 : " + num + "<br>");
		resp.getWriter().println("메일주소 : " + add + "<br>");
		resp.getWriter().println("카카오톡 아이디 : " + kaka + "<br>");
		resp.getWriter().println("팀장 여부 : " + "팀장" + chk_info + "<br>");
		resp.getWriter().println("GitHub Id : " + git + "<br>");
		resp.getWriter().println("등록되었습니다." + "<br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
	}
}
package kr.ac.shinhan.cs;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
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
		boolean chk_info = req.getParameter("chk_info") != null;
		
		String git = req.getParameter("git");

		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = new TeamMember(name, id, num, add, kaka, chk_info, git);
		pm.makePersistent(m);

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>" + "팀 멤버 등록" + "</h1>" + "<br>");
		resp.getWriter().println("<table border = 1>");
		resp.getWriter().println("이름 : " + name + " <br> ");
		resp.getWriter().println("학번 : " + id + "<br>");
		resp.getWriter().println("전화번호 : " + num + "<br>");
		resp.getWriter().println("메일주소 : " + add + "<br>");
		resp.getWriter().println("카카오톡 아이디 : " + kaka + "<br>");
		resp.getWriter().println("팀장여부 : ");
		if(chk_info == true){
			resp.getWriter().println("팀장"+ "<br>");
		}
		else
			resp.getWriter().println("팀원"+ "<br>");
		resp.getWriter().println("GitHub Id : " + req.getParameter("git") + "<br>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("등록되었습니다." + "<br>");

		resp.getWriter().println("<br>");
		resp.getWriter().println("<a href='registmember.html'>이전으로</a>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}
}
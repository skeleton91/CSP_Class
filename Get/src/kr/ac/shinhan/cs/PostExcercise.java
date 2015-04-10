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
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String num = req.getParameter("num");
		String add = req.getParameter("add");
		String kaka = req.getParameter("kaka");
		boolean chk_info = req.getParameter("chk_info") != null;
		String git = req.getParameter("git");
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		TeamMember m = MyPersistenceManager.addMember(name, id, num, add, kaka, git, chk_info);
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("called PostExcercise.doPost() </br>");
		resp.getWriter().println("�̸� : "+m.getName() +"<br>");
		resp.getWriter().println("�й� : "+m.getId() +"<br>");
		resp.getWriter().println("��ȭ��ȣ : "+m.getNum() +"<br>");
		resp.getWriter().println("�����ּ� : "+m.getAdd() +"<br>");
		resp.getWriter().println("īī���� ���̵� : "+m.getKaka() +"<br>");
		resp.getWriter().println("���忩�� : "+m.isChk_info() +"<br>");
		resp.getWriter().println("GitHub id : "+m.getGit() +"<br>");
		resp.getWriter().println("��ü Ű : "+m.getKey() +"<br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
	}
}
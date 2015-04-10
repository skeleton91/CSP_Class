package kr.ac.shinhan.cs;


import java.awt.Checkbox;
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
		
		
		PersistenceManager pm= JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = new TeamMember(name, id, num, add, kaka, chk_info, git);
		pm.makePersistent(m);
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("�� ��� ���"+"<br>");
		resp.getWriter().println("�̸� : " + name + " <br> ");
		resp.getWriter().println("�й� : " + id + "<br>");
		resp.getWriter().println("��ȭ��ȣ : " + num + "<br>");
		resp.getWriter().println("�����ּ� : " + add + "<br>");
		resp.getWriter().println("īī���� ���̵� : " + kaka + "<br>");
		if(chk_info == true)
			resp.getWriter().println("���忩��: ����"+"<br>");
		else
			resp.getWriter().println("���忩��: ����"+"<br>");
		resp.getWriter().println("GitHub Id : " + req.getParameter("git") + "<br>");
		resp.getWriter().println("��ϵǾ����ϴ�." + "<br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
	}
}
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
		resp.getWriter().println("�� ��� ���asdf");
		resp.getWriter().println("�̸� : " + name + " <br> ");
		resp.getWriter().println("�й� : " + id + "<br>");
		resp.getWriter().println("��ȭ��ȣ : " + num + "<br>");
		resp.getWriter().println("�����ּ� : " + add + "<br>");
		resp.getWriter().println("īī���� ���̵� : " + kaka + "<br>");
		resp.getWriter().println("���� ���� : " + "����" + chk_info + "<br>");
		resp.getWriter().println("GitHub Id : " + git + "<br>");
		resp.getWriter().println("��ϵǾ����ϴ�." + "<br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
	}
}
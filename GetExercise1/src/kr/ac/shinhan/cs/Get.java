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
		resp.getWriter().println("�� ��� ���"+"<br>");
		resp.getWriter().println("�̸� : " + req.getParameter("name") + " <br> ");
		resp.getWriter().println("�й� : " + req.getParameter("id") + "<br>");
		resp.getWriter().println("��ȭ��ȣ : " + req.getParameter("num") + "<br>");
		resp.getWriter().println("�����ּ� : " + req.getParameter("add") + "<br>");
		resp.getWriter().println("īī���� ���̵� : " + req.getParameter("kaka") + "<br>");
		if(req.getParameter("chk_info") != null)
			resp.getWriter().println("���忩��: ����"+"<br>");
		else
			resp.getWriter().println("���忩��: ����"+"<br>");
		resp.getWriter().println("GitHub Id : " + req.getParameter("git") + "<br>");
		resp.getWriter().println("��ϵǾ����ϴ�." + "<br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
	}
}
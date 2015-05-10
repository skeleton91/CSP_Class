package kr.ac.shinhan.cs;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateMember extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException { 
		String key =  req.getParameter("key");
		Long longKey = Long.parseLong(key);
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String num = req.getParameter("num");
		String email = req.getParameter("email");
		String kakaoid = req.getParameter("kakaoid");
		String gitid = req.getParameter("gitid");		
		boolean check = req.getParameter("chk_info") != null;
		
		PersistenceManager pm = MyPersistenceManager.getManager();
		TeamMember tm =  pm.getObjectById(TeamMember.class,longKey);
		
		tm.setName(name);
		tm.setid(id);
		tm.setNum(num);
		tm.setEmail(email);
		tm.setKakaoid(kakaoid);
		tm.setGitid(gitid);
		tm.setChk_info(check);
		pm.close();
		
		String title = req.getParameter("title");
		HttpSession session = req.getSession();
		session.setAttribute("title", title);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
	
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("title : " + session.getAttribute("title"));
		resp.getWriter().println("theater : " + req.getParameter("theater"));
		resp.getWriter().println("<h1>" + "������ ���� �ش� ������ ������ �����Ǿ����ϴ�" + "</h1>");
		resp.getWriter().println("<table border=1>");
		resp.getWriter().println("<tr>"+ "<td>" +"�̸�  " +"</td>" +"<td>" + name + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"�й�  " +"</td>" +"<td>" + id + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"��ȭ��ȣ : " +"</td>" +"<td>" + num + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"�����ּ� : " +"</td>" +"<td>" + email + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"īī���� ���̵� : " +"</td>" +"<td>" + kakaoid + "</td>" + "</tr>");
		if(check != true)
			resp.getWriter().println("<tr>"+ "<td>" +"���忩��" +"</td>" +"<td>" + "�����Դϴ�" + "</td>" + "</tr>");
		else
			resp.getWriter().println("<tr>"+ "<td>" +"���忩��" +"</td>" +"<td>" + "����" + "</td>" + "</tr>");
		resp.getWriter().println("<tr>"+ "<td>" +"GitHub ID" +"</td>" +"<td>" + gitid + "</td>" + "</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("<a href=" +"retrive" + ">" + "�ڷΰ���" + "</a>"+"</br>");
		resp.getWriter().println("<a href=" +"index.html" + ">" + "ó������" + "</a>"+"</br>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
	}
}

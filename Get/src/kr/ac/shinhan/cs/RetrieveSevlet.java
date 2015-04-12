package kr.ac.shinhan.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetrieveSevlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		List<TeamMember> memberList = MyPersistenceManager.getAllMembers();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		
		
		resp.getWriter().println("<HTML>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>" + "�� ��� ��ȸ" + "</h1>" + "<br>");
		resp.getWriter().println("<table border = 1>");
		resp.getWriter().println("<tr bgcolor = '#ffddff'>");

		resp.getWriter().println("<td>�̸�</td><td>�й�</td><td>��ȭ��ȣ</td><td>�����ּ�</td><td>īī������̵�</td><td>���忩��</td><td>GitHub Id</td>");

		resp.getWriter().println("</tr>");
			
		for (TeamMember m : memberList) {
			
			if(m.isChk_info() == true)
				{resp.getWriter().println("<tr bgcolor = '#ddddff'>");
				resp.getWriter().println( 
						"<td>" + "<a href = '/ReadMemberSevlet?name=" + m.getName()
						+ "'>" + m.getName() + "</a>" + "</td><td>"
						+ m.getId() + "</td>" + "<td>" + m.getNum()
						+ "</td>" + "<td>" + m.getAdd() + "</td>" + "<td>"
						+ m.getKaka() + "</td>" + "<td>" +  "����" + "</td>"
						+ "<td>" + m.getGit() + "</td>" + "<td>"
						+ "<a href= '/DeleteSevlet?key=" + m.getKey()
						+ "'>" + "���� </a>" + "</td>");}
			else
				{resp.getWriter().println("<tr bgcolor = '#ddddff'>");
				resp.getWriter().println( 
						"<td>" + "<a href = '/ReadMemberSevlet?name=" + m.getName()
						+ "'>" + m.getName() + "</a>" + "</td><td>"
						+ m.getId() + "</td>" + "<td>" + m.getNum()
						+ "</td>" + "<td>" + m.getAdd() + "</td>" + "<td>"
						+ m.getKaka() + "</td>" + "<td>" +  "����" + "</td>"
						+ "<td>" + m.getGit() + "</td>" + "<td>"
						+ "<a href= '/DeleteSevlet?key=" + m.getKey()
						+ "'>" + "���� </a>" + "</td>");}

			resp.getWriter().println("</tr>");
		}

		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</HTML>");

	}
}

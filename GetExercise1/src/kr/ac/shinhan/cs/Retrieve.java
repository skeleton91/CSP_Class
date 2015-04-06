package kr.ac.shinhan.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Retrieve extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		List<TeamMember> memberList = MyPersistenceManager.getAllMembers();
		
		resp.getWriter().println("<HTML>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<table border = 1>");
		for(TeamMember m :memberList)
		{
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td>"+"<a href = '/ReadMemberServlet?name="+m.getName()+"'>"+m.getName()+"</a>"+"</td><td>"+m.getSosialNum()+"</td>");
			resp.getWriter().println("</tr>");
		}
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</HTML>");
		
	}

}

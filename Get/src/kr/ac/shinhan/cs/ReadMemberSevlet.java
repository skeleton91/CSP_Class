package kr.ac.shinhan.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

public class ReadMemberSevlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String name = req.getParameter("name");
		List<TeamMember> namedMemberList = MyPersistenceManager.getMemberByName(name);
		TeamMember m = namedMemberList.get(0);
		
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/plain"); 
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<form method=\'post\' action=\'/UpdateMember?key=" + m.getKey() +"'>" );
 		resp.getWriter().println("<table border = 1>");
 			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<td> 이름 </td>" + "<td>" + "<input type = 'text'  name = 'name'>" + "</td>");
 			resp.getWriter().println("</tr>");
 			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<td> 학번 </td>" + "<td>" + "<input type = 'text'  name = 'id'>" + "</td>");
 			resp.getWriter().println("</tr>");
 			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<td> 전화번호 </td>" + "<td>" + "<input type = 'text'  name = 'num'>" + "</td>");
 			resp.getWriter().println("</tr>");
			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<td> 메일주소 </td>" + "<td>" + "<input type = 'text'  name = 'add'>" + "</td>");
 			resp.getWriter().println("</tr>");
 			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<td> 카카오톡 아이디 </td>" + "<td>" + "<input type = 'text'  name = 'kaka'>" + "</td>");
 			resp.getWriter().println("</tr>");
 			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<td> 팀장여부 </td>" + "<td>" + "<input type = 'checkbox'  name = 'chk_info'>" + "</td>");
 			resp.getWriter().println("</tr>");
 			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<td> GitHub Id </td>" + "<td>" + "<input type = 'text'  name = 'git'>" + "</td>");
 			resp.getWriter().println("</tr>");
 			
 			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<input type='submit' value = '전송'>");
 			resp.getWriter().println("</tr>");
 			resp.getWriter().println("</table>");
 			resp.getWriter().println("<br>");
 			resp.getWriter().println("<tr>");
 			resp.getWriter().println("<td>" +  "<a href='/retrieve'>이전으로</a>" +  "</td>");
 			resp.getWriter().println("</tr>");
 			
 			
 		resp.getWriter().println("</form>");
      resp.getWriter().println("</tr>");
   
   resp.getWriter().println("</body>");
   resp.getWriter().println("</html>");
	}
}
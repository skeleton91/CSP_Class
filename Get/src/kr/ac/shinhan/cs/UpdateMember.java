package kr.ac.shinhan.cs;

import java.io.IOException;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMember extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)	throws IOException {
	
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		
		TeamMember newMember = MyPersistenceManager.getMember("key");
		TeamMember memberObject = MyPersistenceManager.getMember(newMember.getKey() + "");
		memberObject.setName(newMember.getName());
		memberObject.setId(newMember.getId());
		memberObject.setNum(newMember.getNum());
		memberObject.setAdd(newMember.getAdd());
		memberObject.setKaka(newMember.getKaka());
		memberObject.setChk_info(newMember.isChk_info());
		memberObject.setGit(newMember.getGit());
		
		pm.close();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>" + "팀 멤버 등록" + "</h1>" + "<br>");
		resp.getWriter().println("<table border = 1>");
		resp.getWriter().println("이름 : " + newMember.getName() + " <br> ");
		resp.getWriter().println("학번 : " + newMember.getId() + "<br>");
		resp.getWriter().println("전화번호 : " + newMember.getNum() + "<br>");
		resp.getWriter().println("메일주소 : " + newMember.getAdd() + "<br>");
		resp.getWriter().println("카카오톡 아이디 : " + newMember.getKaka() + "<br>");
		resp.getWriter().println("팀장여부 : ");
		if(newMember.isChk_info() == true){
			resp.getWriter().println("팀장"+ "<br>");
		}
		else
			resp.getWriter().println("팀원"+ "<br>");
		resp.getWriter().println("GitHub Id : " + newMember.getGit() + "<br>");
		resp.getWriter().println("등록되었습니다." + "<br>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("<br>");
		resp.getWriter().println("<a href='/retrieve'>이전으로</a>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
		
		
		
	}
}

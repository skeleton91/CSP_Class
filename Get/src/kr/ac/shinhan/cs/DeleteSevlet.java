package kr.ac.shinhan.cs;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSevlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp, String key) throws IOException{
		
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		
		
		
		TeamMember m = MyPersistenceManager.getMember(key);
		
		pm.deletePersistent(m);
		
	
	

	}
}

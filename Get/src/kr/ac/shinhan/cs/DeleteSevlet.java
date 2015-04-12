package kr.ac.shinhan.cs;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSevlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)	throws IOException {
	
		 PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
		            "transactions-optional").getPersistenceManager();
		   String key =  req.getParameter("key");
		      Long Key = Long.parseLong(key);
		      
		     
		      TeamMember m = pm.getObjectById(TeamMember.class,Key); 
		      pm.deletePersistent(m);
		
		
		
		
		
	}
}

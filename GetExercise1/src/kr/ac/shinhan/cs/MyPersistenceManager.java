package kr.ac.shinhan.cs;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class MyPersistenceManager {
	
	public static TeamMember addMember(String uname, String socialNumber)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = new TeamMember(uname,socialNumber);
		pm.makePersistent(m);
		
		return m;
	}
	
	public static TeamMember getMember(String key)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = pm.getObjectById(TeamMember.class,key);
		
		return m;
	}
	
	public static void deleteMember(String key)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = MyPersistenceManager.getMember(key);
		
		pm.deletePersistent(m);
	}
	
	public static List<TeamMember> getMemberByName(String uname)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(TeamMember.class);
		qry.setFilter("uname == nameParam");
		qry.declareParameters("String nameParam");
		
		List<TeamMember> memberList = (List<TeamMember>) qry.execute(uname);
		
		return memberList;
	}
	
	public static List<TeamMember> getAllMembers()
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(TeamMember.class);
		List<TeamMember> memberList = (List<TeamMember>) qry.execute();

		return memberList;
	}
}
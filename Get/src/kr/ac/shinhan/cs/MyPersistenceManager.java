package kr.ac.shinhan.cs;
import java.awt.Checkbox;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class MyPersistenceManager {
	
	public static TeamMember addMember(String name, String id, String num, String add, String git, String kaka, boolean chk_info)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = new TeamMember(name,id,num,add,kaka,chk_info,git);
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
	
	public static List<TeamMember> getMemberByName(String name)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(TeamMember.class);
		qry.setFilter("name == nameParam");
		qry.declareParameters("String nameParam");
		
		List<TeamMember> memberList = (List<TeamMember>) qry.execute(name);
		
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
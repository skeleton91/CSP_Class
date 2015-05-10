package kr.ac.shinhan.cs;

import java.awt.Checkbox;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

public class MyPersistenceManager {


	public static PersistenceManager getManager()
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		return pm;
	}
}

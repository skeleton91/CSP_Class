package kr.ac.shinhan.cs;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TeamMember {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	@Persistent
	private String uname;
	@Persistent
	private String sosialNum;

	public TeamMember(String uname, String socialNum)
	{
		this.uname = uname;
		this.sosialNum = socialNum;
	}

	public String getName() {
		return uname;
	}

	public void setName(String uname) {
		this.uname = uname;
	}

	public String getSosialNum() {
		return sosialNum;
	}

	public void setSosialNum(String sosialNum) {
		this.sosialNum = sosialNum;
	}

	public Long getKey() {
		return key;
	}
	
}

package kr.ac.shinhan.cs;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.servlet.http.HttpServlet;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TeamMember extends HttpServlet {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	@Persistent
	private String name;
	@Persistent
	private String id;
	@Persistent
	private String num;
	@Persistent
	private String add;
	@Persistent
	private String kaka;
	@Persistent
	private boolean chk_info;
	@Persistent
	private String git;

	public TeamMember(String name, String id, String num, String add,String kaka, boolean chk_info, String git) {
		this.name = name;
		this.id = id;
		this.num = num;
		this.add = add;
		this.chk_info = chk_info;
		this.kaka = kaka;
		this.git = git;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getKaka() {
		return kaka;
	}

	public void setKaka(String kaka) {
		this.kaka = kaka;
	}

	public boolean isChk_info() {

		return chk_info;
	}

	public void setChk_info(boolean chk_info) {

		this.chk_info = chk_info;
	}

	public String getGit() {
		return git;
	}

	public void setGit(String git) {
		this.git = git;
	}

	public Long getKey() {
		return key;
	}

}

package cn.com.yajiaotong.wface.entity;

import java.util.List;

public class Author extends WBaseEntity{

	private static final long serialVersionUID = 8953050690359046650L;
	
	private String authorid;//作者编号
	private String authorname;//作者名
	
	//一对多的关系
    private List<Relation> infoList;
    
	public List<Relation> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<Relation> infoList) {
		this.infoList = infoList;
	}
	public Author() {
		super();
	}
 
 
	public Author(String authorid, String authorname) {
		super();
		this.authorid = authorid;
		this.authorname = authorname;
	}


	public String getAuthorid() {
		return authorid;
	}


	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}


	public String getAuthorname() {
		return authorname;
	}


	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
	
}

package cn.com.yajiaotong.wface.entity;

import java.util.List;

public class Type extends WBaseEntity{

	private static final long serialVersionUID = 5596273279156357833L;
	
	private  int news_typeid;//类别编号
	private String news_typename;//类别名称
	
	//一对多的关系
    private List<Relation> infoList;
    
	public List<Relation> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<Relation> infoList) {
		this.infoList = infoList;
	}
	public Type() {
		super();
	}
	
	public Type(int news_typeid, String news_typename,
			List<Relation> infoList) {
		super();
		this.news_typeid = news_typeid;
		this.news_typename = news_typename;
		this.infoList = infoList;
	}
	
	
	public int getNews_typeid() {
		return news_typeid;
	}
	public void setNews_typeid(int news_typeid) {
		this.news_typeid = news_typeid;
	}
	public String getNews_typename() {
		return news_typename;
	}
	public void setNews_typename(String news_typename) {
		this.news_typename = news_typename;
	}
	
	
}

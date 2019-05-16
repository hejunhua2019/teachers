package cn.com.yajiaotong.wface.entity;

public class Services extends WBaseEntity{
	
	//客服信息管理实体类
	private static final long serialVersionUID = -5229871572055965622L;
	
	private String name;//客户姓名
	private String phone;//客服电话
	private int number;//咨询次数
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
    
}
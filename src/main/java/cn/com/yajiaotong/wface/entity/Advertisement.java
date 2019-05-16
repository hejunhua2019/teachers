package cn.com.yajiaotong.wface.entity;

public class Advertisement extends WBaseEntity{
   
	private static final long serialVersionUID = -8487580196986486239L;
	
	private String name;//广告名称
	private String position;//广告位置
	private byte[] picture;//图片
	private String address;//跳转地址
	private int sort;//排序
	private int clicks;//点击数
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}	
   
    
}
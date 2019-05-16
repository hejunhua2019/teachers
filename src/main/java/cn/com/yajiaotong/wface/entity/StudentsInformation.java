package cn.com.yajiaotong.wface.entity;



/**
 * 
 * @author hejunhua
 * @date 2019-03-15
 */
public class StudentsInformation extends WBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7777842206242783985L;
	
	private String name;//学员姓名;
	private int age;//学员年龄;
	private String highestEducation;//学员的最高学历;
	private int socialAge;//学员的社保年限;
	private char houseProperty;//学员在深圳是否有房产（1：有，0：没有）
	private String mobile;//学员的手机号码;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public int getSocialAge() {
		return socialAge;
	}
	public void setSocialAge(int socialAge) {
		this.socialAge = socialAge;
	}
	public char getHouseProperty() {
		return houseProperty;
	}
	public void setHouseProperty(char houseProperty) {
		this.houseProperty = houseProperty;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
